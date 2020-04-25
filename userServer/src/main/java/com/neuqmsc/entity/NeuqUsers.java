package com.neuqmsc.entity;

import java.io.Serializable;

public class NeuqUsers implements Serializable {
    private Integer userId;

    private String userName;

    private String userAccount;

    private String userPassword;

    private Integer userLevel;

    private Integer peopleManage;

    private Integer remark;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPeopleManage() {
        return peopleManage;
    }

    public void setPeopleManage(Integer peopleManage) {
        this.peopleManage = peopleManage;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }
}