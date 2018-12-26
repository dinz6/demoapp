package com.manage.demoapp.organizationmanage.model;

import com.manage.demoapp.organizationmanage.model.enums.OrganizationType;

/**
 * Create by peter
 * Date 2018-12-26  21:53
 * Description:
 */
public class Organization {


    private String id;
    private String name;
    private OrganizationType type;//类型
    private double price;
    private int numBeds;//床位数
    private int numOccupancies;//入住数
    private String manager;//负责人
    private String contactNumber;//联系电话
    private String address;//地址
    private String description;//简介

    private int assessmentStars;//评估星级
    private String assessmentResult;//评估结果


    Organization() {
    }


    /**
     * 获取空闲的床位数
     *
     * @return
     */
    public int getIdleBeds() {
        return numBeds - numOccupancies;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public OrganizationType getType() {
        return type;
    }

    void setType(OrganizationType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public int getNumBeds() {
        return numBeds;
    }

    void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getNumOccupancies() {
        return numOccupancies;
    }

    void setNumOccupancies(int numOccupancies) {
        this.numOccupancies = numOccupancies;
    }

    public String getManager() {
        return manager;
    }

    void setManager(String manager) {
        this.manager = manager;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssessmentStars() {
        return assessmentStars;
    }

    void setAssessmentStars(int assessmentStars) {
        this.assessmentStars = assessmentStars;
    }

    public String getAssessmentResult() {
        return assessmentResult;
    }

    void setAssessmentResult(String assessmentResult) {
        this.assessmentResult = assessmentResult;
    }
}
