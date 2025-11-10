package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.MessageBoardPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.MessageBoard;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.MessageBoardService
 * Date: 2025-11-10 11:40
 * Description:
 */
public interface MessageBoardService extends IService<MessageBoard> {
    IPage<MessageBoardPageDTO> selectPage(Page<MessageBoardPageDTO> page, MessageBoard messageBoard);
}
