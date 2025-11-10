package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.UserEventLogPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.UserEventLog;
import com.manincorp.trading.mapper.UserEventLogMapper;
import com.manincorp.trading.service.UserEventLogService;
import com.manincorp.trading.utils.SetDateTimeUtil;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.UserEventLogImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class UserEventLogImpl extends ServiceImpl<UserEventLogMapper, UserEventLog> implements UserEventLogService {

    @Override
    public boolean save(UserEventLog userEventLog) {
        userEventLog.setCreatedAt(SetDateTimeUtil.getNowTime());
        return super.save(userEventLog);
    }

    @Override
    public IPage<UserEventLogPageDTO> selectPage(Page<UserEventLogPageDTO> page, UserEventLogPageDTO userEventLogPageDTO) {
            return baseMapper.selectPage(page, userEventLogPageDTO);
    }
}
