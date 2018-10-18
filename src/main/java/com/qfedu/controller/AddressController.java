package com.qfedu.controller;

import com.qfedu.service.IAddressService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/selectAddressByUid.do")
    public R selectAddressByUid(int uid){
        return addressService.selectAddressByUid(uid);
    }
}
