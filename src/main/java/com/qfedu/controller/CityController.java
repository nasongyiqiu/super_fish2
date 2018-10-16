package com.qfedu.controller;

import com.qfedu.service.ICityService;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/findGoodsCity.do")
    public PageBean findGoodsCity(int page, int size, HttpServletRequest request) {
        return cityService.findGoodsByCity(page, size, request);
    }
}
