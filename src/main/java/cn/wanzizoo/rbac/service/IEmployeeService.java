package cn.wanzizoo.rbac.service;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/10 5:01 下午
 * @description: 员工的service
 **/
public interface IEmployeeService {
    void saveOrUpdate(Employee employee);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();

    PageResult<Employee> query(QueryObject qo);
}
