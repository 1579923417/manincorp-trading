package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.UserEventLogPageDTO
 * Date: 2025-11-10 16:05
 * Description:
 */
@Data
public class UserEventLogPageDTO {

    private Integer id;
    private Integer userId;
    private String  username;

    private String  eventType;
    private String  targetType;
    private Integer targetId;

    private String  articleTitle;
    private String  brandName;
    private String  productName;

    private String startTime;
    private String endTime;

    private String  createdAt;
}
