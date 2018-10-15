package com.qfedu.mapper;

import com.qfedu.domain.BrowHistory;
import com.qfedu.domain.Goods;

import java.util.List;
import java.util.Map;

public interface BrowHistoryMapper {
    int insert(BrowHistory record);

    List<Goods> selectAllBH(Map<String, Object> map);

    public int countToBH(String username);

}