package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Logs;
import com.ssm.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
@RequestMapping("/")
public class LogsHandler {
    @Autowired
    private LogsService logsServiceImpl;
    @RequestMapping("log")
    public ModelAndView log(@RequestParam(value = "curPage",defaultValue = "1",required = false) Integer curPage){
        ModelAndView mv=new ModelAndView("log");
        int cPage=1;
        if(curPage!=null){
            cPage=curPage;
        }
        PageHelper.startPage(cPage,5);
        List<Logs> list=logsServiceImpl.getAllLogs();
        PageInfo pageInfo=new PageInfo(list,5);
        mv.addObject("pageInfo",pageInfo);
        return mv;

    }
}
