package com.manincorp.trading.controller.web;

import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.SystemConfigGroupDTO;
import com.manincorp.trading.entity.SystemConfig;
import com.manincorp.trading.service.SystemConfigService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.web.WebSystemConfigController
 * Date: 2025-11-19 11:00
 * Description:
 */
@RestController
@RequestMapping("/web/systemConfig")
public class WebSystemConfigController {

    @Resource
    private SystemConfigService systemConfigService;

    /**
     * Get all config items by group
     */
    @GetMapping("/groups/items")
    public Result getConfigsByGroup(@RequestParam(required = false) String enGroupName,
                                    @RequestParam(required = false) String zhGroupName) {
        List<SystemConfig> items = systemConfigService.getConfigsByGroup(enGroupName, zhGroupName);
        return Result.success(items);
    }
}
