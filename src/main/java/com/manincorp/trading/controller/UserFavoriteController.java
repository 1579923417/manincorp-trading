package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.UserFavoritePageDTO;
import com.manincorp.trading.entity.Advertisement;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.entity.UserFavorite;
import com.manincorp.trading.service.UserFavoriteService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.UserFavoriteController
 * Date: 2025-11-10 09:33
 * Description:
 */
@RestController
@RequestMapping("/userFavorite")
public class UserFavoriteController {

    @Resource
    private UserFavoriteService userFavoriteService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserFavorite userFavorite) {
        if (userFavoriteService.existsByUserIdAndProductId(
                userFavorite.getUserId(), userFavorite.getProductId())) {
            return Result.error(ResultCodeEnum.ALREADY_FAVORITE);
        }
        userFavoriteService.save(userFavorite);
        return Result.success(userFavorite);
    }

    /**
     * cancel
     */
    @DeleteMapping("/cancel")
    public Result deleteById(@RequestParam Integer userId,
                             @RequestParam Integer productId) {
        boolean removed = userFavoriteService.cancelFavorite(userId, productId);
        return removed ? Result.success() : Result.error(ResultCodeEnum.NO_FAVORITE_FOUND);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             UserFavoritePageDTO userFavoritePageDTO) {
        Page<UserFavoritePageDTO> page = new Page<>(pageNum, pageSize);
        IPage<UserFavoritePageDTO> list = userFavoriteService.selectPage(page, userFavoritePageDTO);
        return Result.success(list);
    }
}
