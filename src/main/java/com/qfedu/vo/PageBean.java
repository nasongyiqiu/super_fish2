package com.qfedu.vo;

public class PageBean {
    private int currpage;
    private int size;
    private int titlepage;
    private Object data;

    public PageBean() {}

    public PageBean(int currpage, int size, int titlepage, Object data) {
        this.currpage = currpage;
        this.size = size;
        this.titlepage = titlepage;
        this.data = data;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTitlepage() {
        return titlepage;
    }

    public void setTitlepage(int titlepage) {
        this.titlepage = titlepage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
