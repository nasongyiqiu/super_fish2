package com.qfedu.vo;

import com.qfedu.domain.Goods;
import com.qfedu.domain.Grade;

import java.util.List;
import java.util.Map;

//这个是等级和商品的vo类
public class GGVo {
   // 二级列表
    private Grade twograde;

    public Grade getTwograde() {
        return twograde;
    }

    public void setTwograde(Grade twograde) {
        this.twograde = twograde;
    }

    public List<Grade> getThreegrade() {
        return threegrade;
    }

    public void setThreegrade(List<Grade> threegrade) {
        this.threegrade = threegrade;
    }

    public Map<String, List<Goods>> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, List<Goods>> goods) {
        this.goods = goods;
    }

    //三级类表
    private List<Grade> threegrade;
    //三级列表下的商品
    Map<String,List<Goods>> goods;



}
