package cn.wanzizoo.rbac.web.controller;

import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.query.EmployeeQueryObject;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IDepartmentService;
import cn.wanzizoo.rbac.service.IEmployeeService;
import cn.wanzizoo.rbac.service.IRoleService;
import cn.wanzizoo.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/10 11:26 上午
 * @description: 员工控制器
 **/
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IRoleService roleService;


    @RequestMapping("/list")
    @RequiredPermission({"员工列表","employee:list"})
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo) {
        model.addAttribute("result", employeeService.query(qo));
        model.addAttribute("depts", departmentService.listAll());
        return "/employee/list";
    }

    @RequestMapping("/delete")
    @RequiredPermission({"员工删除","employee:delete"})
    public String delete(Long id, QueryObject qo) {
        if (null != id) {
            employeeService.delete(id);
        }
        return "redirect:/employee/list.do?currentPage=" + qo.getCurrentPage();
    }

    @RequestMapping("/input")
    @RequiredPermission({"员工编辑","employee:input"})
    public String input(Model model, Long id, Integer currentPage) {
        if (null != id) {
            model.addAttribute("e", employeeService.get(id));
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("depts", departmentService.listAll());
        model.addAttribute("roles", roleService.listAll());
        return "/employee/input";
    }


    @RequestMapping("/saveOrUpdate")
    @RequiredPermission({"员工保存或更新","employee:saveOrUpdate"})
    public String saveOrUpdate(Employee e, Long[] roleIds, Integer currentPage) {
        employeeService.saveOrUpdate(e,roleIds);
        return "redirect:/employee/list.do?currentPage=" + currentPage;
    }


}
