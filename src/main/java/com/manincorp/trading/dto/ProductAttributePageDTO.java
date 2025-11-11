package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductAttributeDTO
 * Date: 2025-11-11 14:04
 * Description:
 */
@Data
public class ProductAttributePageDTO {
    private Integer id;
    private Integer productId;
    private String productName;
    private String name;
    private String value;
    private String createdAt;
}
