package com.manincorp.trading.controller;

import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.service.ProductAttributeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.productAttributeController
 * Date: 2025-11-06 18:10
 * Description:
 */
@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeController {

    @Resource
    private ProductAttributeService productAttributeService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductAttribute productAttribute) {
        productAttributeService.save(productAttribute);
        return Result.success(productAttribute);
    }

    /**
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        productAttributeService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        productAttributeService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody ProductAttribute productAttribute) {
        productAttributeService.updateById(productAttribute);
        return Result.success(productAttribute);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ProductAttribute productAttribute = productAttributeService.getById(id);
        return Result.success(productAttribute);
    }


    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<ProductAttribute> productAttributelist = productAttributeService.list();
        return Result.success(productAttributelist);
    }

//    /**
//     * page
//     */
//    @GetMapping("/selectPage")
//    public Result selectPage(@RequestParam Integer pageNum,
//                             @RequestParam Integer pageSize,
//                             ProductAttribute productAttribute) {
//        Page<ProductAttributeDTO> page = new Page<>(pageNum, pageSize);
//        IPage<ProductAttributeDTO> list = productAttributeService.selectPage(page, productAttribute);
//        return Result.success(list);
//    }

}
