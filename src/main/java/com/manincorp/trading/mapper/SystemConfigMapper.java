package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manincorp.trading.dto.SystemConfigGroupDTO;
import com.manincorp.trading.entity.SystemConfig;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.SystemConfigMapper
 * Date: 2025-11-19 11:22
 * Description:
 */
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    List<String> selectAllGroupNames();

    List<SystemConfig> selectConfigByGroup(SystemConfigGroupDTO groupDTO);

    String selectConfigValue(String enGroupName, String configKey);
}
