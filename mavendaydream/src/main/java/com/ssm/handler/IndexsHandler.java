package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Customer;
import com.ssm.pojo.Month;
import com.ssm.pojo.MonthInfo;
import com.ssm.pojo.Notice;
import com.ssm.service.IndexsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexsHandler {

    @Autowired
    private IndexsService indexsServiceImple;


    @RequestMapping("inotice")
    public ModelAndView noticeInfo(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("main");
        List<Notice> noticeList = indexsServiceImple.getNotice();
        List<Month> monthList = indexsServiceImple.getCustomerMonth();
        List<MonthInfo> monthInfos = indexsServiceImple.getMonthInfo();
        int lpn = 1;
        int rpn = 1;
        if(request.getParameter("lpn") != null){
            lpn = Integer.parseInt(request.getParameter("lpn"));
        }
        if(request.getParameter("rpn") != null){
            rpn = Integer.parseInt(request.getParameter("rpn"));
        }
        PageHelper.startPage(lpn,4);
        List<Customer> lcustomers = indexsServiceImple.getCustomerDone();
        PageInfo lpageInfo = new PageInfo(lcustomers,4);
        modelAndView.addObject("lpageInfo",lpageInfo);
        PageHelper.startPage(rpn,4);
        List<Customer> rcustomers = indexsServiceImple.getCustomerReady();
        PageInfo rpageInfo = new PageInfo(rcustomers,4);
        modelAndView.addObject("rpageInfo",rpageInfo);
        String mdoor = null;
        String enlist = null;
        for(Notice notice:noticeList){
            System.out.println(notice);
        }
        for(Month months:monthList){
            System.out.println(months);
        }
        for(MonthInfo monthInfo:monthInfos){
            System.out.println(monthInfo);
            Integer num = monthInfo.getMhasdone()+monthInfo.getMnodone();
            double doors = (monthInfo.getHasdoor()*1.0)/num;
            double reports = (monthInfo.getMhasdone()*1.0)/num;
            NumberFormat nf = NumberFormat.getPercentInstance();
            nf.setMinimumFractionDigits(0);
            mdoor = nf.format(doors);
            enlist = nf.format(reports);
            System.out.println(mdoor + "," + enlist);
        }
        modelAndView.addObject("noticeList",noticeList);
        modelAndView.addObject("monthList",monthList);
        modelAndView.addObject("monthInfos",monthInfos);
        modelAndView.addObject("mdoor",mdoor);
        modelAndView.addObject("enlist",enlist);
        return modelAndView;
    }

    @RequestMapping("inotice/lsend")
    @ResponseBody
    public List<Customer> lsend(@RequestParam String cpage){
        int lpn = 1;
        if(cpage != null){
            lpn = Integer.parseInt(cpage);
        }
        System.out.println(lpn);
        PageHelper.startPage(lpn,4);
        List<Customer> lcustomers = indexsServiceImple.getCustomerDone();
        PageInfo lpageInfo = new PageInfo(lcustomers,4);
        List<Customer> customerList = lpageInfo.getList();
        return customerList;
    }

    @RequestMapping("inotice/rsend")
    @ResponseBody
    public List<Customer> rsend(@RequestParam String rcpage){
        int rpn = 1;
        if(rcpage != null){
            rpn = Integer.parseInt(rcpage);
        }
        System.out.println(rpn);
        PageHelper.startPage(rpn,4);
        List<Customer> rcustomers = indexsServiceImple.getCustomerReady();
        PageInfo rpageInfo = new PageInfo(rcustomers,4);
        List<Customer> customerList = rpageInfo.getList();
        return customerList;
    }
}
