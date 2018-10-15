package com.qfedu.mapper;

import com.qfedu.domain.GiveMsg;

public interface GiveMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GiveMsg record);

    int insertSelective(GiveMsg record);

    GiveMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GiveMsg record);

    int updateByPrimaryKey(GiveMsg record);
}