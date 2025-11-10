package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.Advertisement
 * Date: 2025-11-03 10:36
 * Description:
 */
@Data
@TableName("advertisement")
public class Advertisement {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String position;
    private String linkUrl;
    private String createdAt;
}
