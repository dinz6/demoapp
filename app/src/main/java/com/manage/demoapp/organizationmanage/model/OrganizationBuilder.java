package com.manage.demoapp.organizationmanage.model;

import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.App;
import com.manage.demoapp.organizationmanage.model.enums.OrganizationType;

import java.util.List;

/**
 * Create by peter
 * Date 2018-12-26  22:21
 * Description:
 */
public class OrganizationBuilder {
    public static int ID_INDEX = 0;

    private static final int INDEX = 11010000;

    private Organization organization;

    private OrganizationBuilder(Organization organization) {
        this.organization = organization;
    }

    public static OrganizationBuilder builder() {
        Organization organization = new Organization();
        organization.setId(generateId());
        return new OrganizationBuilder(organization);
    }

    public OrganizationBuilder setName(String name) {
        this.organization.setName(name);
        return this;
    }

    public OrganizationBuilder setType(OrganizationType type) {
        this.organization.setType(type);
        return this;
    }

    public OrganizationBuilder setPrice(double price) {
        this.organization.setPrice(price);
        return this;
    }

    public OrganizationBuilder setNumBeds(int numBeds) {
        this.organization.setNumBeds(numBeds);
        return this;
    }

    public OrganizationBuilder setNumOccupancies(int numOccupancies) {
        this.organization.setNumOccupancies(numOccupancies);
        return this;
    }

    public OrganizationBuilder setManager(String manager) {
        this.organization.setManager(manager);
        return this;
    }

    public OrganizationBuilder setContactNumber(String contactNumber) {
        this.organization.setContactNumber(contactNumber);
        return this;
    }

    public OrganizationBuilder setAddress(String address) {
        this.organization.setAddress(address);
        return this;
    }

    public OrganizationBuilder setDescription(String description) {
        this.organization.setDescription(description);
        return this;
    }

    public OrganizationBuilder setAssessmentStars(int assessmentStars) {
        this.organization.setAssessmentStars(assessmentStars);
        return this;
    }

    public OrganizationBuilder setAssessmentResult(String assessmentResult) {
        this.organization.setAssessmentResult(assessmentResult);
        return this;
    }

    public OrganizationBuilder setPicture(List<LocalMedia> list){
        this.organization.setPicList(list);
        return this;
    }

    public Organization build(){
        return this.organization;
    }
    /**
     * 生成id
     *
     * @return
     */
    private static String generateId() {
        String index = String.valueOf(INDEX);
        int anInt = App.getSharedPreferences().getInt(App.ORGANIZATION_ID, 0);
        String id = index + (anInt < 9 ? "0" + ++anInt : ++anInt);
        App.getSharedPreferences().edit().putInt(App.ORGANIZATION_ID, anInt).apply();
        return id;
    }

}
