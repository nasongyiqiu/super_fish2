package com.qfedu.controller;

import com.qfedu.domain.Goods;
import com.qfedu.service.IGoodsService;
import com.qfedu.vo.GGVo;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/findAllGoods.do")
    public PageBean findAllGoodsByPage(int page, int size) {
        return goodsService.findAllGoodsByPage(page,size);
    }


    //点击三级列表展示数据的方法
    @RequestMapping("/clickthree.do")
    public void showthreegoods (int gradeid){
        List<Goods> list = goodsService.findthreegoods(gradeid);
    }

    //点击二级列表展示商品的方法
    @RequestMapping("/clicktwo.do")
    public void showgoods (Integer id){
        id=8;
      Map<String,List<Goods>> map= goodsService.showgradetwogoods(id);
        System.out.println(map);
    }

    //点击一级列表所需展示的商品
    @RequestMapping("/clickone.do")
    public  List<GGVo> showonegoods(Integer id){
    List<GGVo> list= goodsService.findallgoods(1);
        System.out.println(list);
        return list;
    }

    @GetMapping("/findGoodsByGradeName.do")
    public List<Goods> findGoodsByGradeName(String gradeName) {
        List<Goods> list = goodsService.findGoodsByGradeName(gradeName);
        return list;
    }

    @GetMapping("/findGoodsByTwoGrade.do")
    public List<Goods> findGoodsByTwoGrade(String twograde) {
        List<Goods> list = goodsService.findGoodsByGradeName(twograde);
        System.out.println("666"+list);
        return list;
    }

}



