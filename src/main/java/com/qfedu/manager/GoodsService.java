package com.qfedu.manager;

import com.qfedu.domain.Goods;
import com.qfedu.mapper.GoodsMapper;
import com.qfedu.service.IGoodsService;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

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
}
