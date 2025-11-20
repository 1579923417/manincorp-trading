package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.entity.Advertisement;
import com.manincorp.trading.entity.ArticleCategory;
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

    List<Advertisement> selectByPosition(@Param("position") String position,@Param("lang") String lang);

    IPage<Advertisement> selectPage(Page<Advertisement> page, @Param("advertisement") Advertisement advertisement);
}
