package com.qfedu.controller;

import com.qfedu.service.ICartService;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {
    @Autowired
    private ICartService cartService;

    //将商品加入购物车
    @RequestMapping("insertCart.do")
    public R insertCart(HttpServletRequest request,int goodId){
        return ResultUtil.setRes(cartService.insertCart(goodId,request));
    }

    //查询某个用户的购物车，按照加入时间的倒序
    @RequestMapping("selectCartByUid.do")
    public R selectCartByUid(Integer page, Integer size, HttpServletRequest request){
        return new R(1,"查询购物车成功",cartService.selectCartByUid(page,size,request));
    }

    //购买某个商品时，直接将该商品从购物车中删除
    @RequestMapping("/buygoods.do")
    public R buy(HttpServletRequest request,int goodId,int addressid){
        return cartService.deleteCartByUidAndGoodId(request,goodId,addressid);
    }

}
