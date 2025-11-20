package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.Product
 * Date: 2025-11-03 10:36
 * Description:
 */
@Data
@TableName("product")
public class Product {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer brandId;
    private Integer categoryId;
    private String name;
    private String image;
    private String description;
    private Integer isFeatured;
    private String lang;
    private String createdAt;
}
