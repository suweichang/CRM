package com.ssm.handler;

import com.ssm.pojo.Teacher;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class TeacherHandler {
    @Autowired
    private TeacherService teacherServiceImpl;

    @RequestMapping("teacher")
    public ModelAndView GetAllEmps(){
        ModelAndView mv=new ModelAndView("teacher");
        List<Teacher> list=teacherServiceImpl.GetAllTeachers();
        mv.addObject("list",list);
        return mv;
    }
}
