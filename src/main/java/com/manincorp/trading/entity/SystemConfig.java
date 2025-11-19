package com.manincorp.trading.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * author: Jamie
 * Package: com.manincorp.trading.entity.SystemConfig
 * Date: 2025-11-19 10:45
 * Description:
 */
@Data
@TableName("system_config")
public class SystemConfig {
    private Integer id;
    private String enGroupName;
    private String zhGroupName;
    private String configKey;
    private String configValue;
    private String description;
}
