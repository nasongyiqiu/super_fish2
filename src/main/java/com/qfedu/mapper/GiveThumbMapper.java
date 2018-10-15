package com.qfedu.mapper;

import com.qfedu.domain.GiveThumb;

public interface GiveThumbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GiveThumb record);

    int insertSelective(GiveThumb record);

    GiveThumb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GiveThumb record);

    int updateByPrimaryKey(GiveThumb record);
}