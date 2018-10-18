package com.qfedu.service;

import com.qfedu.domain.Order;
import com.qfedu.vo.PageBean;
import com.qfedu.vo.R;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IOrderService {
    //插入订单数据
    public R insertOrder(Order order);

    public PageBean selectAllOrder(int page, int size, HttpServletRequest request);
    /*public PageBean selectAllOrder(int page, int size,int uid);*/

    public R updateOrderStateByUid(HttpServletRequest request,int goodId,int stateChange);
}
