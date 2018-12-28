package com.manage.demoapp.staffmanage.model;

import java.util.Arrays;
import java.util.List;

public class OrgConstants {

    public static List<Org> orgs() {
        Org a = new Org("A100000000", "夕阳红老年公寓");
        Org b = new Org("A100000001", "宿迁养老机构");
        Org c = new Org("A100000002", "滨湖老年服务站");

        return Arrays.asList(a, b, c);
    }
}
