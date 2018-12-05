package com.ssm.handler;

import com.ssm.pojo.*;
import com.ssm.service.ModelsService;
import com.ssm.service.RoleesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
public class RoleesHandler {
    @Autowired
    private RoleesService roleesServiceImpl;
    @Autowired
    private ModelsService modelsServiceImpl;
    @RequestMapping("role")
    public ModelAndView role(){
        List<Rolees> list=roleesServiceImpl.getAllRoless();
        ModelAndView mv=new ModelAndView("role");
        mv.addObject("roleInfo",list);
        return mv;

    }
    @RequestMapping("updateRoleStatus/{role_id}/{status}")
    public String updateRoleStatus(@PathVariable(value = "role_id") Integer role_id,@PathVariable(value = "status") String status){
        RoleUpdate roleUpdate=new RoleUpdate(role_id,status);
        roleesServiceImpl.updateRoleStatus(roleUpdate);
        return "redirect:/role";
    }
    @RequestMapping("updateRole/{role_id}")
    public ModelAndView updateRole(@PathVariable(value = "role_id") Integer role_id){

        ModelAndView mv=new ModelAndView("updateRole");
        List<Power> list=roleesServiceImpl.getPowerByRoleid(role_id);;
        String power=new String();
        for(int i=0;i<list.size();i++){
            power=power+list.get(i).getModel_id()+"#";
        }
        mv.addObject("power",power);
        List<Models> list1=modelsServiceImpl.getParentModelStatus();
        mv.addObject("parentModel",list1);
        Rolees rolees=roleesServiceImpl.getRoleByid(role_id);
        mv.addObject("role",rolees);
        return mv;

    }
    @RequestMapping("updateRole")
    public String updateRole(HttpServletRequest request){
        int role_id=0;
        String roleid=request.getParameter("role_id");
        role_id=Integer.parseInt(roleid);
        String role_name=request.getParameter("role_name");
        roleesServiceImpl.updateRoleName(role_id,role_name);
        List<String> powers=Arrays.asList(request.getParameterValues("power"));;
        roleesServiceImpl.deletePower(role_id);
        for (int i=0;i<powers.size();i++){
            int model_id=Integer.parseInt(powers.get(i));
            AddPower addPower=new AddPower(role_id,model_id);
            roleesServiceImpl.addPower(addPower);
        }
        request.getSession().setAttribute("flush","haha");
        return "redirect:/index";
    }
    @RequestMapping("addRole")
    public ModelAndView addRole(){
        ModelAndView mv=new ModelAndView("addrole");
        List<Models> list1=modelsServiceImpl.getParentModelStatus();
        mv.addObject("parentModel",list1);
        return mv;
    }
    @RequestMapping("addRoles")
    public String addRoles(HttpServletRequest request){
        String role_name=request.getParameter("role_name");
        roleesServiceImpl.addRole(role_name);
        Rolees rolees=roleesServiceImpl.getRoleesByName(role_name);
        List<String> powers=Arrays.asList(request.getParameterValues("power"));;
        for (int i=0;i<powers.size();i++){
            int model_id=Integer.parseInt(powers.get(i));
            AddPower addPower=new AddPower(rolees.getRole_id(),model_id);
            roleesServiceImpl.addPower(addPower);
        }
        return "redirect:/role";
    }
}
