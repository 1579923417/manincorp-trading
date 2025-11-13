package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.UserDto
 * Date: 2025-11-06 10:56
 * Description:
 */
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String nickname;
    private String avatar;
    private String role;
    private String token;
}
