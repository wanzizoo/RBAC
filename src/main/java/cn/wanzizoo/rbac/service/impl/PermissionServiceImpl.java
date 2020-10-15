package cn.wanzizoo.rbac.service.impl;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.domain.Permission;
import cn.wanzizoo.rbac.mapper.PermissionMapper;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/15 6:05 下午
 * @description:
 **/
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Permission> listAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public PageResult<Permission> query(QueryObject qo) {
        //查询总条数
        int count = permissionMapper.selectCount(qo);
        //总条数为0直接返回空PageResult
        if (0 == count) {
            return new PageResult<Permission>(qo.getCurrentPage(), qo.getPageSize());
        }
        //总条数不为0查结果集
        List<Permission> permissions = permissionMapper.selectList(qo);

        //当前业结果集为空查询当前数据最后一页
        if (null == permissions || permissions.size() == 0) {
            int pageSize = qo.getPageSize();
            if (count % pageSize == 0) {
                qo.setCurrentPage(count / pageSize);
            } else {
                qo.setCurrentPage(count / pageSize + 1);
            }
            permissions = permissionMapper.selectList(qo);
        }
        //封装返回
        return new PageResult<Permission>(permissions, qo.getCurrentPage(), qo.getPageSize(), count);

    }

    @Override
    public void reload() {
        //1:获取spring容器
        //2:从容器中获取所有controller
        //3:获取每个controller中的方法
        //4:获取方法上贴的注解
        //5:获取注解中传递的参数
        //6:将参数保存在数据库中
    }
}
