package com.tear.sys.entity;

import javax.persistence.*;

@Entity
@Table

public class thing {
    //商品... sid sname detail  money  status
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer  sid;

    @Column
    private String   sname;

    @Column
    private String  detail;

    @Column
    private double money;

    @Column
    private int status;

    @Column
    private  String   simg;    //通过路径获取图片   仅本地 实用性弱

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //构造

    public thing(Integer sid, String sname, String detail, double money,  String simg,int status) {
        this.sid = sid;
        this.sname = sname;
        this.detail = detail;
        this.money = money;
        this.status = status;
        this.simg = simg;
    }

    public thing() {

    }
}
