package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductDTO
 * Date: 2025-11-07 09:42
 * Description:
 */
@Data
public class ProductDTO {
    private Integer id;
    private String brandName;
    private String categoryName;
    private String name;
    private String description;
    private String image;
}
