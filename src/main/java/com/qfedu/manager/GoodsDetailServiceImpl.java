package com.qfedu.manager;

import com.qfedu.mapper.GoodsMapper;
import com.qfedu.service.GoodsDetailService;
import com.qfedu.vo.GoodsVo;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public R selectGoodsDetail(int goodsId) {
        try {
            return new R(1,"查询成功",goodsMapper.selectByGoodId(goodsId));
        } catch (Exception e) {
            e.printStackTrace();
            return new R(0,"查询失败",null);
        }
    }
}
