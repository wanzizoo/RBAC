package cn.wanzizoo.rbac.service;

import cn.wanzizoo.rbac.domain.Permission;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/15 5:58 下午
 * @description: 权限的service
 **/
public interface IPermissionService {

    void delete(Long id);

    List<Permission> listAll();

    PageResult<Permission> query(QueryObject qo);

    void reload();

}
