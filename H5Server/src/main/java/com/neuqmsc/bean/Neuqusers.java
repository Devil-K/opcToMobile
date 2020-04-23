package com.neuqmsc.bean;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 00:08
 * @ItemName: opcToMobile
 */
public class Neuqusers implements Serializable {
    private Integer User_id;
    private String User_name;
    private String User_account;
    private String User_password;
    private Integer User_level;
    private Integer People_manage;
    private Integer Remark;

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_account() {
        return User_account;
    }

    public void setUser_account(String user_account) {
        User_account = user_account;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    public Integer getUser_level() {
        return User_level;
    }

    public void setUser_level(Integer user_level) {
        User_level = user_level;
    }

    public Integer getPeople_manage() {
        return People_manage;
    }

    public void setPeople_manage(Integer people_manage) {
        People_manage = people_manage;
    }

    public Integer getRemark() {
        return Remark;
    }

    public void setRemark(Integer remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "Neuqusers{" +
                "User_id=" + User_id +
                ", User_name='" + User_name + '\'' +
                ", User_account='" + User_account + '\'' +
                ", User_password='" + User_password + '\'' +
                ", User_level=" + User_level +
                ", People_manage=" + People_manage +
                ", Remark=" + Remark +
                '}';
    }
}
