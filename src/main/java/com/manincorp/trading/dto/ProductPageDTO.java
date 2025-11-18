package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductDTO
 * Date: 2025-11-07 09:42
 * Description:
 */
@Data
public class ProductPageDTO {
    private Integer id;
    private Integer brandId;
    private String brandName;
    private Integer categoryId;
    private String categoryName;
    private String name;
    private String description;
    private String image;
    private Integer isFeatured;
    private String createdAt;
}
