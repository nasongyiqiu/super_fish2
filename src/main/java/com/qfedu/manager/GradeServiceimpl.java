package com.qfedu.manager;

import com.qfedu.domain.Grade;
import com.qfedu.mapper.GradeMapper;
import com.qfedu.service.GradeService;
import com.qfedu.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceimpl implements GradeService {
    //现在注入dao层对象
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<GradeVo> findallgrade() {
            //获得一个返回值对象
        List<GradeVo> list = new ArrayList<>();
            //首先获得一级类表
        List<Grade>one= gradeMapper.grade();
            //遍历存放结果现在得到的是一级对象
        for (Grade grade : one) {
            //来一个Vo类对象
            GradeVo gradeVo=new GradeVo();
            gradeVo.setGrade(grade);
            //然后通过一级对象的id来找二级对象
            int id= grade.getId();
            List<Grade> two=gradeMapper.twograde(id);
            gradeVo.setTwograde(two);
            //然后再来处理三级对象
            Map<String,List<Grade>> map=new HashMap<>();
            for (Grade grade1 : two) {
                int pid= grade1.getId();
                //通过这个id来查找到三级类表
               List<Grade> three= gradeMapper.threegrade(pid);
                String name= grade1.getName().toString();
                map.put(name,three);
                gradeVo.setThreegrade(map);
            }
            //然后将对象放入返回数组中
            list.add(gradeVo);
        }
        return list;
    }
}









