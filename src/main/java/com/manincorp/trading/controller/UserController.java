package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.UserController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * createAdmin
     */
    @PostMapping("/createAdmin")
    public Result createAdmin(@RequestBody User user) {
        userService.createAdmin(user);
        return Result.success(user);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        userService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    /**
     * Query by id
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<User> userList = userService.list();
        return Result.success(userList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = userService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }
}
