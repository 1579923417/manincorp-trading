package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Brand;
import com.manincorp.trading.mapper.BrandMapper;
import com.manincorp.trading.service.BrandService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.BrandServiceImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    @Override
    public boolean save(Brand brand) {
        brand.setCreatedAt(CurrentTimeUtil.getNowTime());
        return super.save(brand);
    }
}
