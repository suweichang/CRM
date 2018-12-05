package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Classs;
import com.ssm.pojo.Interview;
import com.ssm.service.ClasssService;
import com.ssm.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class InterviewHandler {
    @Autowired
    private InterviewService interviewServiceImpl;
    @Autowired
    private ClasssService classsServiceImpl;
    @RequestMapping("interview")
    public ModelAndView interview(Integer cPage, HttpSession session){
        int page = 1;
        int pageSize = 2;
        if(cPage != null){
            if(cPage == 0){
                page = 1;
            }else{
                page = cPage;
            }
        }
        ModelAndView mv = new ModelAndView("interview");
        PageHelper.startPage(page,pageSize);
        List<Interview> list = interviewServiceImpl.getInteList();
        PageInfo<Interview> pageInfo = new PageInfo<>(list);
        mv.addObject("list",pageInfo);
        List<Classs> classlist = classsServiceImpl.GetAllClasss();
        session.setAttribute("classlist",classlist);
        return mv;
    }
    @RequestMapping("addInte")
    public String addInt(String interviewDate,Integer studentId,String interviewContent, Integer classId){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(interviewDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(interviewDate + date);
        Interview interview = new Interview(studentId,classId,date,interviewContent);
        if(interviewServiceImpl.addInte(interview) == 1){
            return "redirect:/interview";
        }else {
            return "redirect:/addInte";
        }
    }

    @RequestMapping("updateInt")
    public String updateInt(String interviewDate,Integer interviewId,String interviewContent){
        Interview interview = new Interview();
        System.out.println(interviewId);
        interview.setInterviewId(interviewId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(interviewDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interview.setInterviewDate(date);
        interview.setInterviewContent(interviewContent);
        if(interviewServiceImpl.updateInte(interview) == 1){
            return "redirect:/interview";
        }else {
            return "redirect:/updateInt";
        }
    }
    @RequestMapping("getIntById")
    public ModelAndView getIntById(Integer id){
        ModelAndView mv = new ModelAndView("updateInt");
        Interview interview = interviewServiceImpl.getIntById(id);
        mv.addObject("temp",interview);
        return mv;
    }
}
