package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.UserEventLogPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.UserEventLog;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.UserEventLogMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface UserEventLogMapper extends BaseMapper<UserEventLog> {

    IPage<UserEventLogPageDTO> selectPage(Page<UserEventLogPageDTO> page, @Param("userEventLog") UserEventLogPageDTO userEventLogPageDTO);
}
