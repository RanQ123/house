package com.team.house.util;

public class HouseCondition extends Page {
    //继承两个属性   page页码  rows页大小
    private String title;
    private Integer did;    //区域的编号 或者区域的名称
    private Integer sid;    //街道编号
    private Integer tid;    //类型编号

    private Long startPrice;    //起始价格
    private Long endPrice;      //结束价格

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Long endPrice) {
        this.endPrice = endPrice;
    }
}
