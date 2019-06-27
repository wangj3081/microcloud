package com.microcloud.dao;

import com.microcloud.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: wangjian
 */
@Mapper
public interface CityDao {

    /**
     * 获取城市列表
     * @return
     */
    List<City> queryCityList();
}
