package com.qfedu.domain;

import java.util.Date;

public class BrowHistory {
    private Integer id;

    private Integer uid;

    private Integer goodid;

    private Date browtime;

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

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Date getBrowtime() {
        return browtime;
    }

    public void setBrowtime(Date browtime) {
        this.browtime = browtime;
    }
}