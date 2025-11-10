package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.productAttribute
 * Date: 2025-11-06 18:04
 * Description:
 */
@Data
public class ProductAttribute {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private String name;
    private String value;
    private String createdAt;
}
