package com.manage.demoapp.servicemanage.model;

public class PensionService {
    private String type;//线上，线下
    private String aktType;//安康通类型
    private String name;//服务名称
    private String serviceId;//编号
    private String detail;//服务项目细节
    private String fee;//服务费用

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAktType() {
        return aktType;
    }

    public void setAktType(String aktType) {
        this.aktType = aktType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
