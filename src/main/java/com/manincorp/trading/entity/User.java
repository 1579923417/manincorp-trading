package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.User
 * Date: 2025-11-03 10:36
 * Description:
 */
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String role;

    @TableField(exist = false)
    private String token;
}
