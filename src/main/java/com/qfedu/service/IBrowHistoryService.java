package com.qfedu.service;

import com.qfedu.vo.PageBean;

import java.util.List;

public interface IBrowHistoryService {

    public PageBean findAllBrowHistoty(int page, int size);
}
