package com.qfedu.service;

import com.qfedu.domain.Goods;
import com.qfedu.vo.GGVo;
import com.qfedu.vo.PageBean;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
    public PageBean findAllGoodsByPage(int page, int size);

    //点击就三级列表查找的的数据
    public List<Goods> findthreegoods(int id);

    //点击二级列表展示的数据
    public Map<String,List<Goods>> showgradetwogoods(int id);

    //点击一级列表展示的数据
    public List<GGVo> findallgoods(int id);

    //根据一级分类展示发布的商品
    List<Goods> findGoodsByGradeName(String gradeName);

    //根据二级分类展示发布的商品
    List<Goods> findByTwoGrade(String twograde);
}
