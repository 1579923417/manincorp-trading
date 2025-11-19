package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.SystemConfigGroupDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.SystemConfig;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.SystemConfigService
 * Date: 2025-11-19 11:20
 * Description:
 */
public interface SystemConfigService extends IService<SystemConfig> {

    List<String> getAllGroupNames();

    List<SystemConfig> getConfigsByGroup(String enGroupName, String zhGroupName);

    String getConfigValue(String enGroupName, String configKey);
}
