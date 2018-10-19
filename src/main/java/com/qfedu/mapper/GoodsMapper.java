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

    //点击三级列表用于展示数据的方法
    public List<Goods> findthreegoods(int id);

    //根据一级分类展示发布的商品
    List<Goods> selectByGradeName(String gradeName);

    //根据二级分类展示发布的商品
    List<Goods> selectByTwoGrade(String twograde);

    //根据三级分类展示发布的商品（苹果商品专栏）
    List<Goods> selectByThreeGrade(String threegrade);

}