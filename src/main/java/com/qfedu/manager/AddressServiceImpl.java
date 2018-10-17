package com.qfedu.manager;

import com.qfedu.mapper.AddressMapper;
import com.qfedu.service.IAddressService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public R selectAddressByUid(int uid) {
        return new R(1,"查询成功", addressMapper.selectAddressByUid(uid));
    }
}
