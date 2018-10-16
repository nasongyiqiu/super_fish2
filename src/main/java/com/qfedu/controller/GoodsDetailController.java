package com.qfedu.controller;

import com.qfedu.service.GoodsDetailService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsDetailController {
    @Autowired
    private GoodsDetailService goodsDetailService;

    //用于查询商品详情
    @RequestMapping("/selectGoosDetails.do")
    public R selectGoosDetails(int goodsId){
        return goodsDetailService.selectGoodsDetail(goodsId);
    }
}
