package com.ssm.handler;

import com.ssm.pojo.Models;
import com.ssm.pojo.Power;
import com.ssm.pojo.Rolees;
import com.ssm.pojo.Useres;
import com.ssm.service.RoleesService;
import com.ssm.service.UseresService;
import com.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/")
public class UsersHandler {
    @Autowired
    private UseresService useresServiceImpl;
    @Autowired
    private RoleesService roleesServiceImpl;

    @RequestMapping("login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {
        if (useresServiceImpl.useresLogin(username, password, request)) {
            Map<Models, List<Models>> maps = useresServiceImpl.getUseresModel(username);
            request.getSession().setAttribute("modelsMap", maps);
            return "redirect:index";
        }
        return "redirect:login.jsp";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        Useres user = (Useres) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:login.jsp";
        } else {
            String username = user.getUser_name();
            Map<Models, List<Models>> maps = useresServiceImpl.getUseresModel(username);
            request.getSession().setAttribute("modelsMap", maps);
            return "redirect:index.jsp";
        }
    }

    @RequestMapping("logoff")
    public String logoff(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("modelsMap");
        return "redirect:login.jsp";
    }

    @RequestMapping("usermngr")
    public ModelAndView userInfo(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("usermngrs");
        int user_id = 0;
        if (request.getParameter("uid") != null) {
            user_id = Integer.parseInt(request.getParameter("uid"));
        }
        List<Rolees> roleesList = roleesServiceImpl.getAllRoles();
        List<Useres> useresList = useresServiceImpl.getAllUser(user_id);
        modelAndView.addObject("roleList", roleesList);
        for (Useres u : useresList) {
            System.out.println(u);
        }
        modelAndView.addObject("useresList", useresList);
        if (user_id == 0) {
            modelAndView.addObject("opr", "info");
        } else {
            modelAndView.addObject("opr", "update");
        }
        return modelAndView;
    }

    @RequestMapping("usermngru")
    public ModelAndView updateUser(Useres useres) {
        ModelAndView modelAndView = new ModelAndView("usermngrs");
        if (useres.getUser_status().equals("0")) {
            useres.setUser_status("1");
        } else if (useres.getUser_status().equals("1")) {
            useres.setUser_status("0");
        }
        useresServiceImpl.updateUser(useres);
        List<Useres> useresList = useresServiceImpl.getAllUser(0);
        modelAndView.addObject("useresList", useresList);
        modelAndView.addObject("opr", "info");
        return modelAndView;
    }

    @RequestMapping("usermngrup")
    public ModelAndView updateUsers(Useres useres, HttpServletRequest request) {
        if (useres.getUser_pwd() != null) {
            useres.setUser_pwd(MD5.md5(useres.getUser_pwd()));
            useresServiceImpl.updateUsers(useres);
        }
        Useres useres1 = (Useres) request.getSession().getAttribute("user");
        if (useres1.getUser_id() == useres.getUser_id()) {
            request.getSession().setAttribute("flush", "haha");
            ModelAndView modelAndView = new ModelAndView("redirect:/index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("usermngrs");
            List<Useres> useresList = useresServiceImpl.getAllUser(0);
            modelAndView.addObject("useresList", useresList);
            modelAndView.addObject("opr", "info");
            return modelAndView;
        }
    }
}
