package com.manage.demoapp.staffmanage.model;

public class SimpleStaff {
    private String name;
    private String gender;
    private String position;
    private String phone;

    public SimpleStaff() {
    }

    public SimpleStaff(String name, String gender, String position, String phone) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
