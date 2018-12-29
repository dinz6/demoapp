package com.manage.demoapp.staffmanage.model;

import java.io.Serializable;

public class StaffDetail implements Serializable {
    private String name;
    private String id;
    private String gender;
    private String phone;
    private String username;
    private String password;
    private String remark;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public StaffDetail(String name, String id, String gender, String phone, String username, String password,
                       String remark, String status) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.remark = remark;
        this.status = status;
    }
}
