package com.manincorp.trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.AdvertisementService
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface AdvertisementService extends IService<Advertisement> {
    List<Advertisement> selectByPosition(String position);
}
