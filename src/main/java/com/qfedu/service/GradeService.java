package com.qfedu.service;

import com.qfedu.vo.GradeVo;

import java.util.List;

public interface GradeService {

    //一个封装三级类表的方法
    public List<GradeVo> findallgrade();
}
