package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.SystemConfigGroupDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.SystemConfig;
import com.manincorp.trading.mapper.ArticleMapper;
import com.manincorp.trading.mapper.SystemConfigMapper;
import com.manincorp.trading.service.ArticleService;
import com.manincorp.trading.service.SystemConfigService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.SystemConfigImpl
 * Date: 2025-11-19 11:20
 * Description:
 */
@Service
public class SystemConfigImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {


    @Resource
    private SystemConfigMapper systemConfigMapper;

    /**
     * Get all distinct group names
     */
    @Override
    public List<String> getAllGroupNames() {
        return systemConfigMapper.selectAllGroupNames();
    }

    @Override
    public List<SystemConfig> getConfigsByGroup(String enGroupName, String zhGroupName) {
        SystemConfigGroupDTO groupDTO = new SystemConfigGroupDTO();
        groupDTO.setEnGroupName(enGroupName);
        groupDTO.setZhGroupName(zhGroupName);
        return systemConfigMapper.selectConfigByGroup(groupDTO);
    }

    @Override
    public String getConfigValue(String enGroupName, String configKey) {
        return systemConfigMapper.selectConfigValue(enGroupName, configKey);
    }

}
