package com.qfedu.vo;

import java.util.Date;

public class GoodsVo {
    private Integer id;

    private Integer uid;

    private Integer gradeid;

    private String name;

    private Double salePrice;

    private Double oldPrice;

    private String goodimage;

    private String gooddescribe;

    private String degree;

    private Date editTime;

    private Integer browNum;

    private Integer thumbNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getGoodimage() {
        return goodimage;
    }

    public void setGoodimage(String goodimage) {
        this.goodimage = goodimage;
    }

    public String getGooddescribe() {
        return gooddescribe;
    }

    public void setGooddescribe(String gooddescribe) {
        this.gooddescribe = gooddescribe;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getBrowNum() {
        return browNum;
    }

    public void setBrowNum(Integer browNum) {
        this.browNum = browNum;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }
}
