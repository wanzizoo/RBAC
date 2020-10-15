package cn.wanzizoo.rbac.service.impl;

import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.domain.Role;
import cn.wanzizoo.rbac.mapper.EmployeeMapper;
import cn.wanzizoo.rbac.mapper.RoleMapper;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IEmployeeService;
import cn.wanzizoo.rbac.service.IRoleService;
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
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void saveOrUpdate(Employee employee, Long[] roleIds) {
        if (null == employee.getId()) {
            //保存员工基本信息
            employeeMapper.insert(employee);
        } else {
            employeeMapper.updateByPrimaryKey(employee);
            //删除旧关系
            employeeMapper.deleteEmpAndRoleRelation(employee.getId());
        }

        //保存员工和角色的关系
        if (null != roleIds && roleIds.length > 0) {
            for (Long roleId : roleIds) {
                employeeMapper.insertEmpAndRoleRelation(employee.getId(),roleId);
            }
        }

    }

    @Override
    public void delete(Long id) {
        //删除员工
        employeeMapper.deleteByPrimaryKey(id);
        //删除关系
        employeeMapper.deleteEmpAndRoleRelation(id);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult<Employee> query(QueryObject qo) {
        //查询总条数
        int count = employeeMapper.selectCount(qo);
        //总条数为0直接返回空PageResult
        if (0 == count) {
            return new PageResult<Employee>(qo.getCurrentPage(), qo.getPageSize());
        }
        //总条数不为0查结果集
        List<Employee> employees = employeeMapper.selectList(qo);

        //当前业结果集为空查询当前数据最后一页
        if (null == employees || employees.size() == 0) {
            int pageSize = qo.getPageSize();
            if (count % pageSize == 0) {
                qo.setCurrentPage(count / pageSize);
            } else {
                qo.setCurrentPage(count / pageSize + 1);
            }
            employees = employeeMapper.selectList(qo);
        }
        //封装返回
        return new PageResult<Employee>(employees, qo.getCurrentPage(), qo.getPageSize(), count);

    }
}
