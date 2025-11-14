package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.Brand;
import com.manincorp.trading.service.BrandService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.BrandController
 * Date: 2025-11-03 10:36
 * Description:
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.save(brand);
        return Result.success(brand);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        brandService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        brandService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return Result.success();
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Brand brand = brandService.getById(id);
        return Result.success(brand);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Brand> brandList = brandService.list();
        return Result.success(brandList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false) String name){
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        if (name != null) {
            wrapper.like("name", name);
        }
        Page<Brand> page = brandService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }
}
