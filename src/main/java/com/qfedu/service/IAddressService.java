package com.qfedu.service;

import com.qfedu.domain.Address;
import com.qfedu.vo.R;

import java.util.List;

public interface IAddressService {
    //查询某个用户的所有收货地址
    R selectAddressByUid(int uid);
}
