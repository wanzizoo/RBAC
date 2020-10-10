package cn.wanzizoo.rbac.service;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Role;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/9 5:58 下午
 * @description: 部门的service
 **/
public interface IRoleService {
    void saveOrUpdate(Role role);

    void delete(Long id);

    Role get(Long id);

    List<Role> listAll();

    PageResult<Role> query(QueryObject qo);
}
