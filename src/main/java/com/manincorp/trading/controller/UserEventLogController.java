package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.common.enums.UserEventTargetTypeEnum;
import com.manincorp.trading.common.enums.UserEventTypeEnum;
import com.manincorp.trading.dto.UserEventLogPageDTO;
import com.manincorp.trading.entity.UserEventLog;
import com.manincorp.trading.service.UserEventLogService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.UserEventLogController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/userEventLog")
public class UserEventLogController {

    @Resource
    private UserEventLogService userEventLogService;

    /**
     * track
     */
    @PostMapping("/track")
    public Result trackEvent(@RequestBody UserEventLog userEventLog) {
        UserEventTypeEnum.fromCode(userEventLog.getEventType());
        UserEventTargetTypeEnum.fromCode(userEventLog.getTargetType());
        userEventLogService.save(userEventLog);
        return Result.success(userEventLog);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        userEventLogService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userEventLogService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody UserEventLog userEventLog) {
        userEventLogService.updateById(userEventLog);
        return Result.success();
    }


    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             UserEventLogPageDTO userEventLogPageDTO) {
        Page<UserEventLogPageDTO> page = new Page<>(pageNum, pageSize);
        IPage<UserEventLogPageDTO> list = userEventLogService.selectPage(page, userEventLogPageDTO);
        return Result.success(list);
    }
}
