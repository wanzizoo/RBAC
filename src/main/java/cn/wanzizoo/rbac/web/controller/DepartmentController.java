package cn.wanzizoo.rbac.web.controller;

import cn.wanzizoo.rbac.domain.Department;
import cn.wanzizoo.rbac.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/9 6:26 下午
 * @description: 部门控制器
 **/
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;


    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", departmentService.listAll());
        return "/department/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (null != id) {
            departmentService.delete(id);
        }
        return "redirect:/department/list.do";
    }

    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (null != id) {
            model.addAttribute("d", departmentService.get(id));
        }
        return "/department/input";
    }


    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Department d){
        departmentService.saveOrUpdate(d);
        return "redirect:/department/list.do";
    }


}
