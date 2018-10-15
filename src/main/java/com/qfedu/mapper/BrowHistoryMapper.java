package com.qfedu.mapper;

import com.qfedu.domain.BrowHistory;

public interface BrowHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrowHistory record);

    int insertSelective(BrowHistory record);

    BrowHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrowHistory record);

    int updateByPrimaryKey(BrowHistory record);
}