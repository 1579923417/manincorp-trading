package com.manincorp.trading.dto;

import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.dto.ArticleDTO
 * Date: 2025-11-06 15:58
 * Description:
*/
@Data
public class ArticleDTO {
    private Integer id;
    private String title;
    private String brandName;
    private String articleCategoryName;
    private String content;
    private Integer publishStatus;
    private Integer viewCount;
    private String createdAt;
}