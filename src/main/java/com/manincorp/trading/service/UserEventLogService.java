package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.UserEventLogPageDTO;
import com.manincorp.trading.entity.UserEventLog;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.UserEventLogService
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public interface UserEventLogService extends IService<UserEventLog> {

    IPage<UserEventLogPageDTO> selectPage(Page<UserEventLogPageDTO> page, UserEventLogPageDTO userEventLogPageDTO);
}
