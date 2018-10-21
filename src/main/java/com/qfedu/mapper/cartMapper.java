package com.qfedu.mapper;

import com.qfedu.domain.cart;

import java.util.List;
import java.util.Map;

public interface cartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(cart cart);

    int insertSelective(cart record);

    List<cart> selectCartByUid(Map<String,Object> map);
    int count(int uid);

    cart selectByUidAndGoodId(cart cart);

    int updateTime(cart cart);

    int deleteByUidAndGoodId(cart cart);

    cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(cart record);

    int updateByPrimaryKey(cart record);
}