package com.qfedu.service;

import com.qfedu.vo.PageBean;

import javax.servlet.http.HttpServletRequest;

public interface ICityService {

    public PageBean findGoodsByCity(int page, int size, HttpServletRequest request);
}
