package com.qfedu.mapper;

import com.qfedu.domain.Grade;

import java.util.List;

public interface GradeMapper {
//返回一级权限的方法
      List<Grade> grade();
    //返回二级权限的方法
    List<Grade> twograde(int id);
    //返回三级权限的方法
    List<Grade> threegrade(int id);


}