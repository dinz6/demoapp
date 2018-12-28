package com.manage.demoapp.staffmanage.model;

import java.util.Arrays;
import java.util.List;

public class StaffConstants {
    public static List<SimpleStaff> simpleStaff(){
        return Arrays.asList(new SimpleStaff("叶春","女","宿迁市","18724190801"),
                new SimpleStaff("陆小秋","女","宿迁市","13852804201"),
                new SimpleStaff("张建军","男","宿迁市","15924007731"));
    }
}
