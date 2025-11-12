package com.manincorp.trading.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.FileController
 * Date: 2025-11-07 14:35
 * Description:
 */
@RestController
@RequestMapping("/files")
public class FileController {

    private static final String filePath = System.getProperty("user.dir") + "/files/";

    @Value("${file.port}")
    private String port;

    @Value("${file.ip}")
    private String ip;

    /**
     * upload file
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return Result.error(ResultCodeEnum.UPLOAD_FILE_EMPTY);
        }

        String flag;
        synchronized (FileController.class) {
            flag = System.currentTimeMillis() + "";
            ThreadUtil.sleep(1L);
        }

        String fileName = file.getOriginalFilename();
        String storedFileName = flag + "-" + fileName;

        try {
            if (!FileUtil.isDirectory(filePath)) {
                FileUtil.mkdir(filePath);
            }
            FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);  // ***/manager/files/1697438073596-avatar.png
            System.out.println(fileName + "--上传成功");
        } catch (Exception e) {
            System.err.println(fileName + "--文件上传失败");
        }
        String httpUrl = "http://" + ip + ":" + port + "/files/" + storedFileName;

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("fileName", storedFileName);
        resMap.put("url", httpUrl);

        return Result.success(resMap);
    }


    /**
     *  file
     */
    @GetMapping("/{flag}")   //  1697438073596-avatar.png
    public void avatarPath(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;
        try {
            if (StrUtil.isNotEmpty(flag)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(flag, StandardCharsets.UTF_8));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(filePath + flag);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

    /**
     * delete file
     */
    @DeleteMapping("/delete")
    public Result delFile(@RequestParam String flag) {
        try {
            File file = new File(filePath + "/" + flag);
            if (file.exists() && file.delete()) {
                System.out.println("删除文件 " + flag + " 成功");
                return Result.success("删除图片成功");
            } else {
                System.out.println("删除文件 " + flag + " 失败");
                return Result.error("删除图片失败", "文件不存在或删除失败");
            }
        } catch (Exception e) {
            System.err.println("删除文件 " + flag + " 时发生异常: " + e.getMessage());
            return Result.error("删除图片失败", e.toString());
        }
    }

    /**
     * wang-editor upload file
     */
    @PostMapping("/wang/upload")
    public Map<String, Object> wangEditorUpload(MultipartFile file) {
        String flag = System.currentTimeMillis() + "";
        String fileName = file.getOriginalFilename();
        try {
            // 文件存储形式：时间戳-文件名
            FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
            System.out.println(fileName + "--上传成功");
            Thread.sleep(1L);
        } catch (Exception e) {
            System.err.println(fileName + "--文件上传失败");
        }
        String http = "http://" + ip + ":" + port + "/files/";
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("errno", 0);
        resMap.put("data", CollUtil.newArrayList(Dict.create().set("url", http + flag + "-" + fileName)));
        return resMap;
    }
}
