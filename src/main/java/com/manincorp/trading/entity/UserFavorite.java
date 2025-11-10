package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.UserFavorite
 * Date: 2025-11-07 12:25
 * Description:
 */
@Data
public class UserFavorite {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer productId;
}
