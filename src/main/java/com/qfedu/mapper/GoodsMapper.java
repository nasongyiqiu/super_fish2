package com.qfedu.mapper;

import com.qfedu.domain.Goods;
import com.qfedu.vo.GoodsVo;

import java.util.List;
import java.util.Map;


public interface GoodsMapper {

    int insertSelective(Goods record);

    //用于商品详情，查询商品以及商品浏览次数
    GoodsVo selectByGoodId(Integer id);


    public List<Goods> selectAllGoodsByPage(Map<String, Object> map);

    public int countTOGoods();
}