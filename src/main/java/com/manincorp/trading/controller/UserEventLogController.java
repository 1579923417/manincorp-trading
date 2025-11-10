package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.UserEventLogPageDTO;
import com.manincorp.trading.entity.UserEventLog;
import com.manincorp.trading.service.UserEventLogService;
import com.manincorp.trading.utils.SetDateTimeUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        userEventLogService.save(userEventLog);
        return Result.success(userEventLog);
    }

    /**
     * delete
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
     * update
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody UserEventLog userEventLog) {
        userEventLogService.updateById(userEventLog);
        return Result.success(userEventLog);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        UserEventLog userEventLog = userEventLogService.getById(id);
        return Result.success(userEventLog);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<UserEventLog> brandList = userEventLogService.list();
        return Result.success(brandList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam Integer pageNum,
                             @RequestParam Integer pageSize,
                             UserEventLogPageDTO userEventLogPageDTO) {
        Page<UserEventLogPageDTO> page = new Page<>(pageNum, pageSize);
        IPage<UserEventLogPageDTO> list = userEventLogService.selectPage(page, userEventLogPageDTO);
        return Result.success(list);
    }
}
