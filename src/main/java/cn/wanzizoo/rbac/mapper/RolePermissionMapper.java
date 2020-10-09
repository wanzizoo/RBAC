package cn.wanzizoo.rbac.mapper;

import cn.wanzizoo.rbac.domain.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    List<RolePermission> selectAll();
}