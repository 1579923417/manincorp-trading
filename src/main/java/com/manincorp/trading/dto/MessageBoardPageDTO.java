package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.MessageBoardPageDTO
 * Date: 2025-11-10 12:26
 * Description:
 */
@Data
public class MessageBoardPageDTO {
    private Integer id;
    private Integer userId;
    private String nickname;
    private String username;
    private String phone;
    private String content;
    private String createdAt;
}
