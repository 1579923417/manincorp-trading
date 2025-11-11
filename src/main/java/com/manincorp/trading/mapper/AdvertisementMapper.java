package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manincorp.trading.entity.Advertisement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.AdvertisementMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface AdvertisementMapper extends BaseMapper<Advertisement> {

    List<Advertisement> selectByPosition(@Param("position") String position);
}
