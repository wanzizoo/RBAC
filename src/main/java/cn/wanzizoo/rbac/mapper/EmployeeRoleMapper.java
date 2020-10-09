package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.EmployeeRole;
import java.util.List;

public interface EmployeeRoleMapper {
    int insert(EmployeeRole record);

    List<EmployeeRole> selectAll();
}