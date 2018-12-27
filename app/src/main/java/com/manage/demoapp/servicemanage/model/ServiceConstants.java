package com.manage.demoapp.servicemanage.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import cn.qqtheme.framework.picker.LinkagePicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceConstants {

    public static List<PensionService> rescue() {
        PensionService a = new PensionService("协助安排救护车辆", "在老人遭遇意外或紧急情况时，协助其呼叫急救中心电话，并跟踪救护车的救援进程", "");
        PensionService b = new PensionService("110报警", "在老人遭遇意外情况时，代为呼叫110，指导急救人员车辆到达客户地点", "");
        PensionService c = new PensionService("火警呼救", "在老人遭遇意外情况时，代为呼叫119，指导急救人员车辆到达客户地点", "");
        PensionService d = new PensionService("联络家属", "在老人遭遇意外或紧急情况时，协助其联系家属或紧急联系人", "");
        return Arrays.asList(a, b, c, d);
    }

    public static List<PensionService> spiritualConsolation() {
        PensionService a = new PensionService("主动关爱", "定期进行电话回访，了解老人需求，关爱老人身心健康", "");
        PensionService b = new PensionService("生日祝福", "电话祝福老人生日快乐并提醒家人陪同老人过生日", "");
        PensionService c = new PensionService("生活信息", "公交线路、火车、飞机、轮船时刻表查询，天气预报及公共机构信息查询", "");

        return Arrays.asList(a, b, c);
    }

    public static List<PensionService> thirdPartyService() {
        PensionService a = new PensionService("水电维修、房屋维修、管道维修、其他服务", "在老人有水电维修、房屋维修、管道疏通等需求时，线上服务人员帮助老人转介第三方服务商，具体维修的服务费用由老人自行承担", "");
        List<PensionService> list = new ArrayList<>();
        list.add(a);
        return list;
    }

    public static List<PensionService> healthManage() {
        PensionService a = new PensionService("建立健康档案", "定期收集老年人血压、血糖、血氧、血脂，体重等必要的健康信息，并记录在案；定期为老人提供义诊，并记录相关义诊数据；根据测量血压、血糖数据以及义诊数据，根据数据更新健康档案", "");
        PensionService b = new PensionService("健康讲座", "在社区不定期举办健康知识讲座", "");
        return Arrays.asList(a, b);
    }

    public static List<PensionService> clean() {
        PensionService a = new PensionService("上门理发", "按规范进行，并处理好地面卫生。", "10-15元/次");
        PensionService b = new PensionService("洗脚，修剪手脚指（趾）甲", "先洗干净，按规范进行修剪，并打磨平滑。", "20元/次");
        PensionService c = new PensionService("房间清洁", "根据老年人的居住情况和实际要求，为老年人的居住场所提供清洁卫生服务、家庭物品收纳整理，辅助老人收物取物便利，地面清洁、家具除尘。", "25元/小时");
        PensionService d = new PensionService("厨房整理", "厨房用具收纳整理、清洁。", "20元/次");
        PensionService e = new PensionService("衣物洗涤", "洗涤前告知、提醒老人将衣物口袋中物品拿出，洗涤分类，并做到洗净、晾晒。", "1、春秋装3-5元/件\n" +
                "2、夏装2-3元/件\n" +
                "3、冬装5-10元/件\n" +
                "4、床上用品5-15元/件\n" +
                "5、毛毯10-20元/件\n" +
                "6、也可以按时间计价，\n" +
                "25元/小时");

        return Arrays.asList(a, b, c, d, e);
    }

    public static List<PensionService> medical() {
        PensionService a = new PensionService("血糖检测", "常规血糖监测，提供康复建议。", "15元/次");
        PensionService b = new PensionService("血压检测", "常规血压监测，提供康复建议。在为老人提供血糖检测等上门服务时顺便为老人进行血压监测。", "免费");
        PensionService c = new PensionService("体温测量", "常规体温监测。在为老人提供血糖检测等上门服务时顺便为老人进行体温测量。", "免费");
        PensionService d = new PensionService("陪诊就医", "助医服务地点为就近的医疗机构；助医服务每次时间为1小时以内，每超出1小时增收5元，不足1小时按1小时计费； 助医服务应注意途中安全。", "20元/时");
        PensionService e = new PensionService("住院陪护", "按服务规范陪护", "日间陪护40-60元、夜间陪护60-80元、24小时陪护80-100元；陪护费也可面议");
        PensionService f = new PensionService("康复护理", "遵照医嘱，协助老年人进行康复运动等，由专业人员为老人进行康复护理服务。", "35元/时");
        return Arrays.asList(a, b, c, d, e, f);
    }

    public static List<PensionService> food() {
        PensionService a = new PensionService("上门做饭", "根据营养学、卫生学要求和老年人需求，为老年人提供助餐服务。上门做饭标准：一荤一素一汤一饭（食材自理）。", "20-30元/时");
        PensionService b = new PensionService("上门送餐", "根据老年人需求，为老年人提供上门送餐服务，为有需要订餐的老人送饭上门（不含餐费）。", "2-5元/次");
        return Arrays.asList(a, b);
    }

    public static List<PensionService> shower() {
        PensionService a = new PensionService("上门助浴", "按照安全防护要求，为有需求的老年人提供上门助浴服务。浴前应进行安全提示，为评估后有助浴条件及身体状况允许的老人助浴，助浴过程需家属陪同。助浴服务每超出1小时增收10元，不足1小时按1小时计时。", "30元/次");
        PensionService b = new PensionService("外出助浴", "按照安全防护要求，为有需求的老年人提供外出助浴服务。为评估后身体状况允许的老人助浴，助浴服务每超出1小时增收10元，不足1小时按1小时计时。", "30元/次\n" +
                "（浴资、交通费自理）");
        return Arrays.asList(a, b);
    }

    public static List<PensionService> walk() {
        PensionService a = new PensionService("陪同散步、陪伴聊天", "陪同老人外出、采购、聊天，使老人保持开朗心情。", "15元/小时");
        List<PensionService> list = new ArrayList<>();
        list.add(a);
        return list;

    }

    public static List<PensionService> entertainment() {
        PensionService a = new PensionService("助乐", "在上门为老人开展其它计费服务时，协助有需求的老年人开展各类有益于身心健康的文体娱乐活动。", "免费");
        List<PensionService> list = new ArrayList<>();
        list.add(a);
        return list;
    }

    public static List<PensionService> emergency() {
        PensionService a = new PensionService("助急", "通过安装呼叫器、求助门铃、远红外感应器等安全防护器材，为有需求的老年人提供紧急救助服务。", "免费\n" +
                "（设备费用由老年人自行承担）");
        List<PensionService> list = new ArrayList<>();
        list.add(a);
        return list;
    }



    public static List<PensionService> agent() {
        PensionService a = new PensionService("代购、代办、代缴", "根据老年人需求，提供代购、代领物品，代缴费用等服务。", "5-10元/次");
        List<PensionService> list = new ArrayList<>();
        list.add(a);
        return list;
    }

    public static LinkagePicker.DataProvider dataProvider = new LinkagePicker.DataProvider() {
        @NonNull
        @Override
        public List<String> provideFirstData() {
            return Arrays.asList("线上", "线下");
        }

        @NonNull
        @Override
        public List<String> provideSecondData(int firstIndex) {
            switch (firstIndex) {
                case 0:
                    return Arrays.asList("救护", "精神慰藉", "第三方转介服务", "老年人健康管理");
                case 1:
                    return Arrays.asList("助洁", "助医", "助餐", "助浴", "助行", "助乐", "助急", "代办");
                default:
                    return new ArrayList<>();
            }
        }

        @Nullable
        @Override
        public List<String> provideThirdData(int firstIndex, int secondIndex) {
            return null;
        }

        @Override
        public boolean isOnlyTwo() {
            return true;
        }
    };



}
