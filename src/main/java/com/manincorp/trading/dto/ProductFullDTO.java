package com.manincorp.trading.dto;

import com.manincorp.trading.entity.ProductAttribute;
import lombok.Data;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ProductDetailDTO
 * Date: 2025-11-07 10:51
 * Description: DTO for product detail page, includes main product info
 *              detailed introduction, content, and associated attributes
 */
@Data
public class ProductFullDTO {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private String brandName;
    private String categoryName;

    // product_detail
    private String introduction;
    private String content;

    // product_attribute list
    private List<ProductAttribute> attributes;
}
