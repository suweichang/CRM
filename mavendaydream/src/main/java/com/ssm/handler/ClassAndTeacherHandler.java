package com.ssm.handler;

import com.ssm.pojo.Classs;
import com.ssm.pojo.Teacher;
import com.ssm.service.ClasssService;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ClassAndTeacherHandler {
        @Autowired
        private TeacherService teacherServiceImpl;

        @Autowired
        private ClasssService classsServiceImpl;

        @RequestMapping("classandteacher")
        public ModelAndView GetAllEmps(HttpServletRequest request){
            String op=request.getParameter("op");
            ModelAndView mv=null;
            if(op!=null && op.equals("activity")){
                mv=new ModelAndView("addactivity");
            }else if(op.equals("review")){
                mv=new ModelAndView("addreview");
            }
            List<Classs> classsList=classsServiceImpl.GetAllClasss();
            mv.addObject("classsList",classsList);
            List<Teacher> teacherslist=teacherServiceImpl.GetAllTeachers();
            mv.addObject("teacherslist",teacherslist);
            return mv;
        }
}
