package com.qfedu.manager;

import com.qfedu.domain.Order;
import com.qfedu.domain.cart;
import com.qfedu.mapper.cartMapper;
import com.qfedu.service.ICartService;
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
public class CartServiceImpl implements ICartService {
    @Autowired
    private cartMapper cartMapper;
    @Autowired
    private IOrderService orderService;

    //将商品添加到指定用户的购物车
    @Override
    public int insertCart(int goodId, HttpServletRequest request) {
        //测试的时候用到
        request.getSession().setAttribute("uid",1);
        cart cart = new cart();


        int uid = (int)request.getSession().getAttribute("uid");
        cart.setUid(uid);
        cart.setGoodid(goodId);
        cart cart1 = cartMapper.selectByUidAndGoodId(cart);
        if (cart1 != null){
            return cartMapper.updateTime(cart);
        }else{
            return cartMapper.insert(cart);
        }
    }

    @Override
    public PageBean selectCartByUid(int page, int size, HttpServletRequest request) {
        PageBean pageBean = null;
        try {
            request.getSession().setAttribute("uid",1);
            int uid = (Integer) request.getSession().getAttribute("uid");
            //查询该用户的总订单个数
            int count = cartMapper.count(uid);
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

            List<cart> list = cartMapper.selectCartByUid(map);
            pageBean = new PageBean(page,size,pageTotal,list);
        } catch (Exception e) {
            throw new RuntimeException("分页出现错误");
        }
        return pageBean;
    }


    @Override
    public R deleteCartByUidAndGoodId(HttpServletRequest request,int goodId,int addressid) {
        cart cart = new cart();
        Order order = new Order();

        int uid = (int)request.getSession().getAttribute("uid");

        cart.setGoodid(goodId);
        cart.setUid(uid);

        order.setAddressid(addressid);
        order.setGoodid(goodId);

        R ret = orderService.insertOrder(order,request);
        if (ret.getCode()>0){
            return ResultUtil.setRes(cartMapper.deleteByUidAndGoodId(cart));
        }else {
            return ResultUtil.setRes(-1);
        }

    }
}
