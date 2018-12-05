package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Classs;
import com.ssm.pojo.Student;
import com.ssm.pojo.Teacher;
import com.ssm.service.ClasssService;
import com.ssm.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentHandler {
    @Autowired
    private StudentService studentServiceImpl;
    @Autowired
    private ClasssService classsServiceImpl;

    @RequestMapping("student")
    public ModelAndView student(Integer cPage, Integer classId, HttpSession session, HttpServletRequest req){
        int page = 1,classid = 0;
        int pageSize = 2;
        if(cPage != null){
            if(cPage == 0){
                page = 1;
            }else{
                page = cPage;
            }
        }
        if(classId != null){
            classid = classId;
        }
        ModelAndView mv = new ModelAndView("student");
        PageHelper.startPage(page,pageSize);
        List<Student> list = new ArrayList<Student>();
        if(classid == 0){
            list = studentServiceImpl.getStuList();
        }else{
            list = studentServiceImpl.getStuByClass(classid);
        }
        System.out.println("-----------" + list);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        mv.addObject("list",pageInfo);
        List<Classs> classlist = classsServiceImpl.GetAllClasss();
        session.setAttribute("classlist",classlist);
        req.setAttribute("classId",classid);
        return mv;
    }

    @RequestMapping("addStu")
    public String addStu(Student stu){
        if(studentServiceImpl.addStu(stu) == 1){
            return "redirect:/student";
        }else{
            return "redirect:/addStu";
        }
    }

    @RequestMapping("updateStu")
    public String updateStu(Student stu){
        if(studentServiceImpl.updateStu(stu) == 1){
            return "redirect:/student";
        }else{
            return "redirect:/updateStu";
        }
    }

    @RequestMapping("getStuById")
    public ModelAndView getStuById(int id){
        ModelAndView mv = new ModelAndView("updateStu");
        Student stu = studentServiceImpl.getStuById(id);
        System.out.println(stu);
        mv.addObject("stu",stu);
        return mv;
    }

    @RequestMapping("getStuByName")
    public ModelAndView getStuByName(String stuName){
        ModelAndView mv = new ModelAndView("getStuByName");
        Student stu = studentServiceImpl.getStuByName(stuName);
        mv.addObject("stuByName",stu);
        return mv;
    }
    @RequestMapping("getStuByClass")
    public ModelAndView getStuByClass(Integer classId, String interviewDate, HttpServletRequest req){
        ModelAndView mv = new ModelAndView("addInt");
        List<Student> list = studentServiceImpl.getStuByClass(classId);
        Teacher teacher = classsServiceImpl.getTeaByTeaid(classId);
        mv.addObject("list",list);
        req.setAttribute("interviewDate",interviewDate);
        req.setAttribute("teacher",teacher);
        req.setAttribute("classId",classId);
        return mv;
    }
    @RequestMapping("getStuByClassA")
    public ModelAndView getStuByClassA(Integer classId, String attendanceDate, HttpServletRequest req){
        ModelAndView mv = new ModelAndView("addAtt");
        List<Student> list = studentServiceImpl.getStuByClass(classId);
        mv.addObject("list",list);
        req.setAttribute("attendanceDate",attendanceDate);
        req.setAttribute("classId",classId);
        return mv;
    }
    @RequestMapping("getStuByClassB")
    public ModelAndView getStuByClassB(Integer classId, String callbackDate, HttpServletRequest req){
        ModelAndView mv = new ModelAndView("addCb");
        List<Student> list = studentServiceImpl.getStuByClass(classId);
        mv.addObject("list",list);
        req.setAttribute("callbackDate",callbackDate);
        req.setAttribute("classId",classId);
        return mv;
    }
//    @RequestMapping("delStu")
//    public String delStu(int id){
//        if(studentServiceImpl.delStuById(id) == 1){
//            return "redirect:/student";
//        }else{
//            return "redirect:/delStu";
//        }
//    }

    @RequestMapping("addStudent")
    public ModelAndView getClasss(){
        ModelAndView mv = new ModelAndView("addStu");
        List<Classs> list = classsServiceImpl.GetAllClasss();
        System.out.println(list);
//        session.setAttribute("classList",list);
        mv.addObject("list",list);
        return mv;
    }
}
