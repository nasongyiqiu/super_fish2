package com.qfedu.service;

import com.qfedu.vo.PageBean;

import java.util.List;

public interface IGoodsService {
    public PageBean findAllGoodsByPage(int page, int size);
}
