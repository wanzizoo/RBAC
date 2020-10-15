package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Permission;
import cn.wanzizoo.rbac.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    List<Permission> selectAll();

    int selectCount(QueryObject qo);

    List<Permission> selectList(QueryObject qo);
}