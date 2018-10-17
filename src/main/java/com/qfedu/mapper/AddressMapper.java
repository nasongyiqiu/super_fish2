package com.qfedu.mapper;

import com.qfedu.domain.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    //通过用户Id查询该用户下的所有地址
    List<Address> selectAddressByUid(Integer uid);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}