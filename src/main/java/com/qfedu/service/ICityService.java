package com.qfedu.service;

import com.qfedu.vo.PageBean;

public interface ICityService {

    public PageBean findGoodsByCity(int page, int size);
}
