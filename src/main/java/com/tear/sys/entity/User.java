package com.tear.sys.entity;

import javax.persistence.*;

//用户实体
@Entity
@Table
public class User {
    //userId  username  password nickname
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private  Integer   userId;
    @Column
    private String   username;
    @Column
    private  String  password;
    @Column
    private String   nickname;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
