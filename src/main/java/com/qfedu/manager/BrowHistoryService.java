package com.qfedu.manager;

import com.qfedu.domain.BrowHistory;
import com.qfedu.domain.Goods;
import com.qfedu.mapper.BrowHistoryMapper;
import com.qfedu.service.IBrowHistoryService;
import com.qfedu.service.IGoodsService;
import com.qfedu.vo.PageBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrowHistoryService implements IBrowHistoryService {
    @Autowired
    private BrowHistoryMapper browHistoryMapper;
    @Autowired
    private IGoodsService goodsService;

    @Override
    public PageBean findAllBrowHistoty(int cpage, int size) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //username="songna";
        PageBean pageBean = null;
        if (null == username) {
            return goodsService.findAllGoodsByPage(cpage, size);
        } else {
            int countToBH = browHistoryMapper.countToBH(username);
            int page = (cpage-1)*size;
            int titlepage = 0;
            if (countToBH%size == 0) {
                titlepage = countToBH/size;
            } else {
                titlepage = countToBH/size + 1;
            }
            Map<String, Object> map  = new HashMap<>();
            map.put("page",  page);
            map.put("size", size);
            map.put("username", username);
            List<Goods> browHistories = browHistoryMapper.selectAllBH(map);
            pageBean = new PageBean(cpage,size, titlepage, browHistories );
        }
        return pageBean;
    }
}
