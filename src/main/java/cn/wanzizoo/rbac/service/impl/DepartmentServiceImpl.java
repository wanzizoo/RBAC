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
        //查询总条数
        int count = departmentMapper.selectCount(qo);
        //总条数为0直接返回空PageResult
        if (0 == count) {
            return new PageResult<Department>(qo.getCurrentPage(), qo.getPageSize());
        }
        //总条数不为0查结果集
        List<Department> departments = departmentMapper.selectList(qo);

        //当前业结果集为空查询当前数据最后一页
        if (null == departments || departments.size() == 0) {
            int pageSize = qo.getPageSize();
            if (count % pageSize == 0) {
                qo.setCurrentPage(count / pageSize);
            } else {
                qo.setCurrentPage(count / pageSize + 1);
            }
            departments = departmentMapper.selectList(qo);
        }
        //封装返回
        return new PageResult<Department>(departments, qo.getCurrentPage(), qo.getPageSize(), count);

    }
}
