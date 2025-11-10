package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.MessageBoard
 * Date: 2025-11-07 12:26
 * Description:
 */
@Data
public class MessageBoard {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String createdAt;
}
