package com.manincorp.trading.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.SystemConfigGroupDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.SystemConfig;
import com.manincorp.trading.service.SystemConfigService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.admin.AdminSystemConfigController
 * Date: 2025-11-19 10:57
 * Description:
 */
@RestController
@RequestMapping("/admin/systemConfig")
public class AdminSystemConfigController {

    @Resource
    private SystemConfigService systemConfigService;

    /**
     * Get all distinct group names
     */
    @GetMapping("/groups")
    public Result getAllGroups() {
        List<String> groups = systemConfigService.getAllGroupNames();
        return Result.success(groups);
    }

    /**
     * Get all config items by group
     */
    @GetMapping("/groups/items")
    public Result getConfigsByGroup(@RequestParam(required = false) String enGroupName,
                                    @RequestParam(required = false) String zhGroupName,
                                    @RequestParam(required = false) String lang) {
        List<SystemConfig> items = systemConfigService.getConfigsByGroup(enGroupName, zhGroupName, lang);
        return Result.success(items);
    }

    /**
     * update by id
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody SystemConfig systemConfig) {
        systemConfigService.updateById(systemConfig);
        return Result.success();
    }

}
