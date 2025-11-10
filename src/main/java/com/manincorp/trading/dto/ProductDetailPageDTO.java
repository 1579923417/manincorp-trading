package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductDetailPageDTO
 * Date: 2025-11-07 13:44
 * Description:
 */
@Data
public class ProductDetailPageDTO {
    private Integer id;
    private String productName;
    private String introduction;
    private String content;
    private String createdAt;
}
