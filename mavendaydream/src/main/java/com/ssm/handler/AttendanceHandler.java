package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Attendance;
import com.ssm.pojo.Classs;
import com.ssm.pojo.Interview;
import com.ssm.service.AttendanceService;
import com.ssm.service.ClasssService;
import com.ssm.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class AttendanceHandler {
    @Autowired
    private AttendanceService attendanceServiceImpl;
    @Autowired
    private ClasssService classsServiceImpl;
    @RequestMapping("attendance")
    public ModelAndView attendance(Integer cPage, HttpSession session){
        int page = 1;
        int pageSize = 2;
        if(cPage != null){
            if(cPage == 0){
                page = 1;
            }else{
                page = cPage;
            }
        }
        ModelAndView mv = new ModelAndView("attendance");
        PageHelper.startPage(page,pageSize);
        List<Attendance> list = attendanceServiceImpl.getAttList();
        PageInfo<Attendance> pageInfo = new PageInfo<>(list);
        mv.addObject("list",pageInfo);
        List<Classs> classlist = classsServiceImpl.GetAllClasss();
        System.out.println(classlist);
        session.setAttribute("classlist",classlist);
        return mv;
    }
    @RequestMapping("addAtt")
    public String addAtt(Integer studentId,String status, Integer classId, String attendanceDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(attendanceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Attendance attendance = new Attendance();
        attendance.setAttendanceDate(date);
        attendance.setStudentId(studentId);
        attendance.setClassId(classId);
        attendance.setStatus(status);
        if(attendanceServiceImpl.addAtt(attendance) == 1){
            return "redirect:/attendance";
        }else {
            return "redirect:/addAtt";
        }
    }

    @RequestMapping("updateAtt")
    public String updateAtt(Integer attendanceId,String status){
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(attendanceId);
        attendance.setStatus(status);
        if(attendanceServiceImpl.updateAtt(attendance) == 1){
            return "redirect:/attendance";
        }else {
            return "redirect:/updateAtt";
        }
    }
    @RequestMapping("getAttById")
    public ModelAndView getIntById(Integer id){
        ModelAndView mv = new ModelAndView("updateAtt");
        Attendance attendance = attendanceServiceImpl.getAttById(id);
        mv.addObject("temp",attendance);
        return mv;
    }
}
