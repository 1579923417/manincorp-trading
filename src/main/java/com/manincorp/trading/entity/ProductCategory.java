package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.ProductCategory
 * Date: 2025-11-03 10:36
 * Description:
 */
@Data
@TableName("product_category")
public class ProductCategory {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer brandId;
    private String name;
    private String lang;
    private String createdAt;
}
