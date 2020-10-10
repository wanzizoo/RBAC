package cn.wanzizoo.rbac.web.controller;

import cn.wanzizoo.rbac.domain.Role;
import cn.wanzizoo.rbac.query.QueryObject;
import cn.wanzizoo.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: RBAC
 * @author: LiuFan
 * @create: 2020/10/10 11:26 上午
 * @description: 角色控制器
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    @RequestMapping("/list")
    public String list(Model model, QueryObject qo) {
        model.addAttribute("result", roleService.query(qo));
        return "/role/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id, QueryObject qo) {
        if (null != id) {
            roleService.delete(id);
        }
        return "redirect:/role/list.do?currentPage=" + qo.getCurrentPage();
    }

    @RequestMapping("/input")
    public String input(Model model, Long id, Integer currentPage) {
        if (null != id) {
            model.addAttribute("r", roleService.get(id));
        }
        model.addAttribute("currentPage", currentPage);
        return "/role/input";
    }


    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role r, Integer currentPage) {
        roleService.saveOrUpdate(r);
        return "redirect:/role/list.do?currentPage=" + currentPage;
    }


}
