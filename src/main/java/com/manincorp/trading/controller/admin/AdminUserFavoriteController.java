package com.manincorp.trading.controller.admin;

import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.ProductFavoriteCountDTO;
import com.manincorp.trading.service.UserFavoriteService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.admin.AdminUserFavoriteController
 * Date: 2025-11-21 10:49
 * Description:
 */
@RestController
@RequestMapping("/admin/userEventLog")
public class AdminUserFavoriteController {

    @Resource
    private UserFavoriteService userFavoriteService;

    @GetMapping("/favoriteCounts")
    public Result getAllFavoriteCounts() {
        List<ProductFavoriteCountDTO> list = userFavoriteService.getAllProductFavoriteCounts();
        return Result.success(list);
    }
}
