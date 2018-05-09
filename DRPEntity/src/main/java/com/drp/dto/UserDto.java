package com.drp.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    private Integer id;
    private String userCode;
    private String userName;
    private String userTel;
    private String userEmail;
    private String createTime;

    public UserDto() {
    }

    public UserDto(Integer id, String userCode, String userName, String userTel, String userEmail, String createTime) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
