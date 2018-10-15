package com.qfedu.controller;

import com.qfedu.service.IGoodsService;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/findAllGoods.do")
    public PageBean findAllGoodsByPage(int page, int size) {
        return goodsService.findAllGoodsByPage(page,size);
    }
}
