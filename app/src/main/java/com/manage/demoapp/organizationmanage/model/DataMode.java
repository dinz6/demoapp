package com.manage.demoapp.organizationmanage.model;

import com.manage.demoapp.organizationmanage.model.enums.OrganizationType;
import com.manage.demoapp.utlis.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织机构数据源
 * Create by peter
 * Date 2018-12-26  22:51
 * Description:
 */
public class DataMode implements DataDao{
    private Map<String, Organization> dataMap = new HashMap<>();

    private static DataMode dataMode = new DataMode();
    private DataMode(){
        initData();
    }

    public static DataMode getInstance(){
        return dataMode;
    }


    /**
     * 初始化数据
     */
    private void initData(){
        Organization org1 = OrganizationBuilder.builder()
                .setAddress("双庄镇敬老院位于双庄镇支口街西")
                .setContactNumber("0527-4593070")
                .setManager("李红辉")
                .setName("双庄镇敬老院")
                .setNumBeds(200)
                .setPrice(45).setAssessmentStars(3)
                .setNumOccupancies(50)
                .setType(OrganizationType.WORK)
                .build();
        Organization org2 = OrganizationBuilder.builder()
                .setAddress("市府东路4号桥下向北100米")
                .setContactNumber("0527-88009933")
                .setManager("李红辉")
                .setName("宿城区康乐老年公寓")
                .setDescription("宿城区康乐老年公寓位于运河路39号（市府东路4号桥下向北100米），占地5500平米，环境优雅，设施豪华全面，欢迎全市中老年朋友前来入住")
                .setNumBeds(200)
                .setPrice(55)
                .setNumOccupancies(150)
                .setType(OrganizationType.WORK)
                .setAssessmentStars(4)
                .build();
        dataMap.put(org1.getName(),org1);
        dataMap.put(org2.getName(),org2);
    }

    @Override
    public List<Organization> findByOrgNameLike(String orgName) {
        List<Organization> orgs = new ArrayList<>();
        List<Organization> all = findAll();
        for (Organization organization : all) {
            String name = organization.getName();
            if (name.contains(orgName))
                orgs.add(organization);
        }
        return orgs;
    }

    @Override
    public void delete(String orgName) {
        dataMap.remove(orgName);
    }

    @Override
    public void save(Organization organization) {
        if (StringUtils.isEmpty(organization.getId())) throw new IllegalArgumentException("id must not be null or empty");
        dataMap.put(organization.getName(),organization);
    }

    @Override
    public Organization findOne(String orgName) {
       return dataMap.get(orgName);
    }

    @Override
    public List<Organization> findAll() {
        return new ArrayList<>(dataMap.values());
    }
}
