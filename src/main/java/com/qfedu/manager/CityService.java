package com.qfedu.manager;

import com.qfedu.domain.Goods;
import com.qfedu.mapper.CityMapper;
import com.qfedu.service.ICityService;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public PageBean findGoodsByCity(int cpage, int size) {
        PageBean pageBean = null;
        try {
            int countTOGoods = cityMapper.countToCityGoods("长春");
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
            map.put("name", "长春");
            List<Goods> goodsList = cityMapper.selectAllGoodsByCity(map);
            pageBean = new PageBean(cpage,size, titlepage, goodsList );
        } catch (Exception e) {
            throw new RuntimeException("分页出现错误");
        }

        return pageBean;
    }
}
