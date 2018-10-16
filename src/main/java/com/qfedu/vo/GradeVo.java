package com.qfedu.vo;

import com.qfedu.domain.Grade;

import java.util.List;
import java.util.Map;

public class GradeVo {

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Grade> getTwograde() {
        return twograde;
    }

    public void setTwograde(List<Grade> twograde) {
        this.twograde = twograde;
    }

    public Map<String, List<Grade>> getThreegrade() {
        return threegrade;
    }

    public void setThreegrade(Map<String, List<Grade>> threegrade) {
        this.threegrade = threegrade;
    }

    //一级列表
    private Grade grade;
    //二级列表
    private List<Grade> twograde;
    //三级列表
    private Map<String,List<Grade>> threegrade;
}






