package com.qfedu.mapper;

import com.qfedu.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    //添加订单
    int insertOrder(Order record);

    //查询用户对应的所有订单，分页
    List<Order> selectAllOrderByUid(Map<String,Object> map);
    //查询指定用户下面的所有订单的个数
    int count(int uid);

    //通过uid与goodId查询指定的订单
    Order selectOrderByUidAndGoodId(Map<String,Object> map);

    //更改订单状态
    int updateOrderStateByUid(Map<String,Object> map);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}