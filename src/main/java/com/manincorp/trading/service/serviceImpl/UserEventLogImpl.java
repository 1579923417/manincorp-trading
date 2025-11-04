package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.UserEventLog;
import com.manincorp.trading.mapper.UserEventLogMapper;
import com.manincorp.trading.service.UserEventLogService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.UserEventLogImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class UserEventLogImpl extends ServiceImpl<UserEventLogMapper, UserEventLog> implements UserEventLogService {
}
