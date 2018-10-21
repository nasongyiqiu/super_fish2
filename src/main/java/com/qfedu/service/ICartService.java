package com.qfedu.service;

import com.qfedu.domain.cart;
import com.qfedu.vo.PageBean;
import com.qfedu.vo.R;

import javax.servlet.http.HttpServletRequest;

public interface ICartService {
    public int insertCart(int goodId, HttpServletRequest request);

    //根据用户按照商品添加购物车的时间倒序查询
    public PageBean selectCartByUid(int page, int size, HttpServletRequest request);

    public R deleteCartByUidAndGoodId(HttpServletRequest request,int goodId,int addressid);
}
