package cn.wanzizoo.rbac.service;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/9 5:58 下午
 * @description: 部门的service
 **/
public interface IDepartmentService {
    void saveOrUpdate(Department department);

    void delete(Long id);

    Department get(Long id);

    List<Department> listAll();

    PageResult<Department> query(QueryObject qo);
}
