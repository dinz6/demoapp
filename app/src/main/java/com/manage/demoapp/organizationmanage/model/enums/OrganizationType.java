package com.manage.demoapp.organizationmanage.model.enums;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Create by peter
 * Date 2018-12-26  21:59
 * Description:
 */
public enum OrganizationType {
    WORK("办公"),
    REST("疗养")
    ;


    private String value;

    OrganizationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
