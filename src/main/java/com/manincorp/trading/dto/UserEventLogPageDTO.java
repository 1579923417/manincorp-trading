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
    private String username;
    private String nickname;
    private Integer articleId;
    private String articleTitle;
    private Integer articleCategoryId;
    private String articleCategoryName;
    private Integer brandId;
    private String brandName;
    private Integer productId;
    private String productName;
    private Integer productCategoryId;
    private String productCategoryName;
    private String  createdAt;
}
