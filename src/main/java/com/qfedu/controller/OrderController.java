package com.qfedu.controller;

import com.qfedu.domain.Order;
import com.qfedu.service.IOrderService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/insertOrder.do")
    public R insertOrder(Order order){
        return new R(1,"插入成功",orderService.insertOrder(order));
    }

    @RequestMapping("/selectAllOrderByUid.do")
    public R selectAllOrderByUid(Integer page, Integer size, HttpServletRequest request){
        return new R(1,"查询订单成功",orderService.selectAllOrder(page,size,request));
    }


    @RequestMapping("/updateOrderState.do")
    public R updateOrderState(HttpServletRequest request, int goodId,int stateChange){
        return new R(1,"",orderService.updateOrderStateByUid(request,goodId,stateChange));
    }
}
