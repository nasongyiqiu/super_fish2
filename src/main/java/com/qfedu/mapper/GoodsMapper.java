package com.qfedu.mapper;

import com.qfedu.domain.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    public List<Goods> selectAllGoodsByPage(Map<String, Object> map);

    public int countTOGoods();
}