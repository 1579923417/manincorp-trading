package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.Article
 * Date: 2025-11-03 10:36
 * Description:
 */
@Data
@TableName("article")
public class Article {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String title;
    private Integer brandId;
    private Integer categoryId;
    private String content;
    private Integer publishStatus;
    private Integer viewCount;
    private String cteatedAt;
}

