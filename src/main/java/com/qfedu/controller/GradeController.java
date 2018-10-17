package com.qfedu.controller;

import com.qfedu.service.GradeService;
import com.qfedu.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GradeController {
    //注入业务层对象
    @Autowired
    private GradeService GradeServiceimpl;
    //先写一个测试方法
    @RequestMapping("/show")
    @ResponseBody
    public List<GradeVo> showallgrade(){
        List<GradeVo> list= GradeServiceimpl.findallgrade();
        return list;
    }




}
