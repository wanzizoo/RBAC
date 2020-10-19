package cn.wanzizoo.rbac.test;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.query.PageResult;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceImplTest {
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void saveOrUpdate() {
        Department department = new Department("测试","11");
        departmentService.saveOrUpdate(department);

    }

    @Test
    public void delete() {
        departmentService.delete(7L);
    }

    @Test
    public void get() {
       /* Department department = departmentService.get(2L);*/
        System.out.println(departmentService.getClass());
    }

    @Test
    public void listAll() {
        List<Department> departments = departmentService.listAll();
        System.out.println(departments.toString());
    }

    @Test
    public void query() {
        PageResult<Department> query = departmentService.query(new QueryObject());
        System.out.println(query);
    }

}