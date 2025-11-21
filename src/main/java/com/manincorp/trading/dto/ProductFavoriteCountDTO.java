package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductFavoriteCountDTO
 * Date: 2025-11-21 10:42
 * Description:
 */
@Data
public class ProductFavoriteCountDTO {
    private String productId;
    private String productName;
    private Integer favoriteCount;
}