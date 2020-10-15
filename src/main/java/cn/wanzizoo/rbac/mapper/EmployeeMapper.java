package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee employee);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee employee);

    int selectCount(QueryObject qo);

    List<Employee> selectList(QueryObject qo);
    //mapper中方法多参数需要加Param注解来封装
    void insertEmpAndRoleRelation(@Param("empId") Long empId,@Param("roleId") Long roleId);

    void deleteEmpAndRoleRelation(Long empId);
}