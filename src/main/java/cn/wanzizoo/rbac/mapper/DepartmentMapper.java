package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    int selectCount(QueryObject qo);

    List<Department> selectList(QueryObject qo);
}