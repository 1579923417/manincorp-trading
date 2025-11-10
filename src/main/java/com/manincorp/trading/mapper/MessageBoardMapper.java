package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.MessageBoardPageDTO;
import com.manincorp.trading.entity.MessageBoard;
import com.manincorp.trading.entity.MessageBoard;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.MessageBoardMapper
 * Date: 2025-11-10 11:40
 * Description:
 */
public interface MessageBoardMapper extends BaseMapper<MessageBoard> {

    IPage<MessageBoardPageDTO> selectPage(Page<MessageBoardPageDTO> page, @Param("messageBoard") MessageBoard messageBoard);
}
