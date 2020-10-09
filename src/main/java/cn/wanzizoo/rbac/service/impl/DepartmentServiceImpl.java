package cn.wanzizoo.rbac.service.impl;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.mapper.DepartmentMapper;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/9 6:01 下午
 * @description:
 **/
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void saveOrUpdate(Department department) {
        if (null == department.getId()) {
            departmentMapper.insert(department);
        } else {
            departmentMapper.updateByPrimaryKey(department);
        }

    }

    @Override
    public void delete(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Department get(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public PageResult<Department> query(QueryObject qo) {


        return null;
    }
}
