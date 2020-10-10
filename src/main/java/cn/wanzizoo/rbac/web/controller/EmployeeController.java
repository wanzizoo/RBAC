package cn.wanzizoo.rbac.web.controller;

import cn.wanzizoo.rbac.domain.Employee;
import cn.wanzizoo.rbac.domain.Role;
import cn.wanzizoo.rbac.query.EmployeeQueryObject;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IDepartmentService;
import cn.wanzizoo.rbac.service.IEmployeeService;
import cn.wanzizoo.rbac.service.IRoleService;
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


    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo) {
        model.addAttribute("result", employeeService.query(qo));
        model.addAttribute("depts", departmentService.listAll());
        return "/employee/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id, QueryObject qo) {
        if (null != id) {
            employeeService.delete(id);
        }
        return "redirect:/employee/list.do?currentPage=" + qo.getCurrentPage();
    }

    @RequestMapping("/input")
    public String input(Model model, Long id, Integer currentPage) {
        if (null != id) {
            model.addAttribute("e", employeeService.get(id));
        }
        model.addAttribute("currentPage", currentPage);
        return "/employee/input";
    }


    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee e, Integer currentPage) {
        employeeService.saveOrUpdate(e);
        return "redirect:/employee/list.do?currentPage=" + currentPage;
    }


}
