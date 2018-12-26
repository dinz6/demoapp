package com.manage.demoapp.organizationmanage.model;

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
        //TODO:添加假数据
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
    public void delete(String id) {
        dataMap.remove(id);
    }

    @Override
    public void save(Organization organization) {
        if (StringUtils.isEmpty(organization.getId())) throw new IllegalArgumentException("id must not be null or empty");
        dataMap.put(organization.getId(),organization);
    }

    @Override
    public void findOne(String id) {
        dataMap.get(id);
    }

    @Override
    public List<Organization> findAll() {
        return new ArrayList<>(dataMap.values());
    }
}
