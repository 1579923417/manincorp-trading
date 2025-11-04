package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Advertisement;
import com.manincorp.trading.mapper.AdvertisementMapper;
import com.manincorp.trading.service.AdvertisementService;
import com.manincorp.trading.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.AdvertisementImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class AdvertisementImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements AdvertisementService {
}
