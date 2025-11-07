package com.manincorp.trading.entity;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.productAttribute
 * Date: 2025-11-06 18:04
 * Description:
 */
@Data
public class ProductAttribute {
    private Integer id;
    private Integer productId;
    private String name;
    private String value;
}
