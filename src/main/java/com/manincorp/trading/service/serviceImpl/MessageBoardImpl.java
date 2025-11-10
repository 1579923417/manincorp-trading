package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.MessageBoardPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.MessageBoard;
import com.manincorp.trading.mapper.MessageBoardMapper;
import com.manincorp.trading.service.ArticleService;
import com.manincorp.trading.service.MessageBoardService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.MessageBoardImpl
 * Date: 2025-11-10 11:40
 * Description:
 */
@Service
public class MessageBoardImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements MessageBoardService {
    @Override
    public IPage<MessageBoardPageDTO> selectPage(Page<MessageBoardPageDTO> page, MessageBoard messageBoard) {
        return baseMapper.selectPage(page, messageBoard);
    }
}
