package com.qfedu.mapper;

import com.qfedu.domain.Goods;

import java.util.List;
import java.util.Map;

public interface CityMapper {
    public List<Goods> selectAllGoodsByCity(Map<String ,Object> map);

    public int countToCityGoods(String name);
}