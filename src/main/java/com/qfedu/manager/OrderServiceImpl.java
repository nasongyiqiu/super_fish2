package com.qfedu.manager;

import com.qfedu.domain.Order;
import com.qfedu.mapper.OrderMapper;
import com.qfedu.service.IOrderService;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.PageBean;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public R insertOrder(Order order) {
        try {
            return new R(1,"插入成功",orderMapper.insertOrder(order));
        } catch (Exception e) {
            e.printStackTrace();
            return new R(0,"插入失败",null);
        }
    }

    @Override
    public PageBean selectAllOrder(int page, int size, HttpServletRequest request) {
        PageBean pageBean = null;
        try {
            request.getSession().setAttribute("uid",1);
            int uid = (Integer) request.getSession().getAttribute("uid");
            //查询该用户的总订单个数
            int count = orderMapper.count(uid);
            int pageTotal = 0;
            if (count%size == 0) {
                pageTotal = count/size;
            } else {
                pageTotal = count/size + 1;
            }
            int index = (page - 1) * size;
            Map<String,Object> map = new HashMap<>();
            map.put("index",index);
            map.put("size",size);
            map.put("uid",uid);

            List<Order> list = orderMapper.selectAllOrderByUid(map);
            pageBean = new PageBean(page,size,pageTotal,list);
        } catch (Exception e) {
            throw new RuntimeException("分页出现错误");
        }
        return pageBean;
    }
    /*@Override
    public PageBean selectAllOrder(int page, int size,int uid) {
        PageBean pageBean = null;
        try {

            //查询该用户的总订单个数
            int count = orderMapper.count(uid);
            int pageTotal = 0;
            if (count%size == 0) {
                pageTotal = count/size;
            } else {
                pageTotal = count/size + 1;
            }
            int index = (page - 1) * size;
            Map<String,Object> map = new HashMap<>();
            map.put("index",index);
            map.put("size",size);
            map.put("uid",uid);

            List<Order> list = orderMapper.selectAllOrderByUid(map);
            pageBean = new PageBean(page,size,pageTotal,list);
        } catch (Exception e) {
            throw new RuntimeException("分页出现错误");
        }
        return pageBean;
    }*/

    //stateChange表示传过来的要改变的状态码，如果状态码，与查到的订单的state相差一，表示需要更改状态码
    //1待支付、2已支付，未发货、3已发货，未收货、4已收货
    @Override
    public R updateOrderStateByUid(HttpServletRequest request, int goodId,int stateChange) {
        try {
            request.getSession().setAttribute("uid",1);
            int uid = (int)request.getSession().getAttribute("uid");

            Map<String,Object> map = new HashMap<>();
            map.put("uid",uid);
            map.put("goodId",goodId);
            Order order = orderMapper.selectOrderByUidAndGoodId(map);

            if (order.getState()==(stateChange-1)){
                int ret = orderMapper.updateOrderStateByUid(map);
                return  ResultUtil.setRes(ret);
            }
            return ResultUtil.setERROR("无法操作");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.setERROR("更改失败");
        }

    }
}
