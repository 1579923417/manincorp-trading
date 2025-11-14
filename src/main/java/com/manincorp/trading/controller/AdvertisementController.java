package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.Advertisement;
import com.manincorp.trading.service.AdvertisementService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.AdvertisementController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Resource
    private AdvertisementService advertisementService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody Advertisement advertisement) {
        advertisementService.save(advertisement);
        return Result.success(advertisement);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        advertisementService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        advertisementService.removeByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Advertisement advertisement) {
        advertisementService.updateById(advertisement);
        return Result.success();
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Advertisement advertisement = advertisementService.getById(id);
        return Result.success(advertisement);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Advertisement> list = advertisementService.list();
        return Result.success(list);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryWrapper<Advertisement> wrapper = new QueryWrapper<>();
        Page<Advertisement> page = advertisementService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }

    /**
     * query by position
     */
    @GetMapping("/selectByPosition")
    public Result selectByPosition(@RequestParam(required = false) String position) {
        List<Advertisement> list = advertisementService.selectByPosition(position);
        return Result.success(list);
    }
}
