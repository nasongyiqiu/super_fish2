package com.qfedu.manager;

import com.qfedu.domain.Goods;
import com.qfedu.domain.Grade;
import com.qfedu.mapper.GoodsMapper;
import com.qfedu.mapper.GradeMapper;
import com.qfedu.service.IGoodsService;
import com.qfedu.vo.GGVo;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public PageBean findAllGoodsByPage(int cpage, int size) {
        PageBean pageBean = null;
        try {
            int countTOGoods = goodsMapper.countTOGoods();
            int page = (cpage-1)*size;
            int titlepage = 0;
            if (countTOGoods%size == 0) {
                titlepage = countTOGoods/size;
            } else {
                titlepage = countTOGoods/size + 1;
            }
            Map<String, Object> map  = new HashMap<>();
            map.put("page",  page);
            map.put("size", size);
            List<Goods> goodsList = goodsMapper.selectAllGoodsByPage(map);
            pageBean = new PageBean(cpage,size, titlepage, goodsList );
        } catch (Exception e) {
            throw new RuntimeException("分页出现错误");
        }

        return pageBean;
    }


    //点击就三级列表查找的的数据
    @Override
    public List<Goods> findthreegoods(int id) {
        List<Goods> list = goodsMapper.findthreegoods(id);
        return list;
    }

    //点击二级列表展示的数据
    @Override
    public Map<String,List<Goods>> showgradetwogoods(int id) {
        Map<String,List<Goods>> map = new HashMap<>();
        //先找到二级列表对应的三级集合
      List<Grade> list = gradeMapper.threegrade(id);
      //然后通过每一个三级列表的ID去找相对应的商品
        for (Grade grade : list) {
            int id1 = grade.getId();
          List<Goods> list1 =  goodsMapper.findthreegoods(id1);
          map.put(grade.getName(),list1);
        }
        return map;
    }


    //点击一级列表展示的数据
    @Override
    public List<GGVo> findallgoods(int id) {
        List<GGVo> arr=new ArrayList<>();
        //首先找到二级对象
       List<Grade> list= gradeMapper.twograde(id);
       for (int i=0;i<list.size();i++) {
           GGVo ggVo = new GGVo();
           for (Grade grade : list) {
               ggVo.setTwograde(grade);
               //现在要找到三级的列表
              int id1= grade.getId();
            List<Grade> list1=  gradeMapper.threegrade(id1);
            ggVo.setThreegrade(list1);
            Map<String ,List<Goods>> map = new HashMap<>();
               for (Grade grade1 : list1) {
                   String name= grade1.getName();
                   int id2= grade1.getId();
                   List<Goods> list2= goodsMapper.findthreegoods(id2);
                   map.put(name,list2);
                   ggVo.setGoods(map);
               }
               arr.add(ggVo);
           }
       }
        return arr;
    }

    @Override
    public List<Goods> findGoodsByGradeName(String gradeName) {
        List<Goods> goodsList = null;
        try {
            goodsList = goodsMapper.selectByGradeName(gradeName);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return goodsList;
    }
}
