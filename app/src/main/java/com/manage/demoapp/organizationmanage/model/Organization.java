package com.manage.demoapp.organizationmanage.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.organizationmanage.model.enums.OrganizationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by peter
 * Date 2018-12-26  21:53
 * Description:
 */
public class Organization implements Parcelable {
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

    private List<LocalMedia> picList = new ArrayList<>();


    Organization() {
    }


    protected Organization(Parcel in) {
        id = in.readString();
        name = in.readString();
        type = OrganizationType.values()[in.readInt()];
        price = in.readDouble();
        numBeds = in.readInt();
        numOccupancies = in.readInt();
        manager = in.readString();
        contactNumber = in.readString();
        address = in.readString();
        description = in.readString();
        assessmentStars = in.readInt();
        assessmentResult = in.readString();
        picList = in.createTypedArrayList(LocalMedia.CREATOR);
    }

    public static final Creator<Organization> CREATOR = new Creator<Organization>() {
        @Override
        public Organization createFromParcel(Parcel in) {
            return new Organization(in);
        }

        @Override
        public Organization[] newArray(int size) {
            return new Organization[size];
        }
    };

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

    public void setName(String name) {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getNumOccupancies() {
        return numOccupancies;
    }

    public void setNumOccupancies(int numOccupancies) {
        this.numOccupancies = numOccupancies;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public void setAssessmentStars(int assessmentStars) {
        this.assessmentStars = assessmentStars;
    }

    public String getAssessmentResult() {
        return assessmentResult;
    }

   public void setAssessmentResult(String assessmentResult) {
        this.assessmentResult = assessmentResult;
    }

    public List<LocalMedia> getPicList() {
        return picList;
    }

    public void setPicList(@NonNull List<LocalMedia> picList) {
        this.picList.addAll(picList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(type.ordinal());
        dest.writeDouble(price);
        dest.writeInt(numBeds);
        dest.writeInt(numOccupancies);
        dest.writeString(manager);
        dest.writeString(contactNumber);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeInt(assessmentStars);
        dest.writeString(assessmentResult);
        dest.writeTypedList(picList);
    }
}
