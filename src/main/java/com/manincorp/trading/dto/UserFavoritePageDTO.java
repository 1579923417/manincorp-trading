package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.UserFavoritePageDTO
 * Date: 2025-11-10 09:48
 * Description:
 */
@Data
public class UserFavoritePageDTO {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private String productName;
}
