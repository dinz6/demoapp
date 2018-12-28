package com.manage.demoapp.organizationmanage.model;

import java.util.List;

/**
 * Create by peter
 * Date 2018-12-26  22:54
 * Description:
 */
public interface DataDao {
    /**
     * 按照组织机构名称来模糊查询
     * @param orgName
     * @return
     */
    List<Organization> findByOrgNameLike(String orgName);

    /**
     * 根据id 来删除一个机构
     * @param id
     */
    void delete(String id);

    /**
     * 新增一个机构
     * @param organization
     */
    void save(Organization organization);

    /**
     * 根据id来查询一个机构
     * @param id
     */
    Organization findOne(String id);

    List<Organization> findAll();

}
