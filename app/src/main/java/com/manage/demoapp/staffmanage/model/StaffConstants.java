package com.manage.demoapp.staffmanage.model;

import java.util.Arrays;
import java.util.List;

public class StaffConstants {
    public static List<SimpleStaff> simpleStaff() {
        return Arrays.asList(new SimpleStaff("叶春", "女", "宿迁市", "18724190801"),
                new SimpleStaff("陆小秋", "女", "宿迁市", "13852804201"),
                new SimpleStaff("张建军", "男", "宿迁市", "15924007731"));
    }

    public static List<StaffDetail> staffDetails() {
        return Arrays.asList(
                new StaffDetail("叶春", "A10000000", "女", "18724190801", "A10000000", "dsf24315", "十番助老员", "审核通过"),
                new StaffDetail("陆小秋", "A10000001", "女", "13852804201", "A10000001", "88661lxq", "", "审核通过"),
                new StaffDetail("张建军", "A10000002", "男", "15924007731", "A10000002", "soissd77s", "", "审核通过"),
                new StaffDetail("李峰", "A10000003", "男", "18766341127", "A10000003", "flzl1114", "", "待审核"),
        new StaffDetail("刘娟", "A10000004", "女", "13726207765", "A10000004", "osdhhkq", "", "待审核")
        );
    }
}
