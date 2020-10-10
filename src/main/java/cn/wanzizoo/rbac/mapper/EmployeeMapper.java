package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int selectCount(QueryObject qo);

    List<Employee> selectList(QueryObject qo);
}