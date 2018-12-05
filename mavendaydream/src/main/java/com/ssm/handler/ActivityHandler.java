package com.ssm.handler;

import com.ssm.pojo.Activity;
import com.ssm.pojo.PageUtil;
import com.ssm.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ActivityHandler {
    @Autowired
    private ActivityService activityServiceImpl;

    @RequestMapping("activity")
    public ModelAndView GetAllEmps(HttpServletRequest request){
        int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 10;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<Activity> pageUtil = new PageUtil<Activity>();//初始化工具类
        List<Activity> list = new ArrayList<Activity>();
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = activityServiceImpl.pagecount();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        pageUtil.setPageCount((int) Math.ceil((double) (pageUtil.getPageNumber() / pageUtil.getPageSize())) + 1);//计算出总页数,并封装到工具类
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        list = activityServiceImpl.GetAllActivity(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(list);//保存到工具类中的集合

        ModelAndView mv=new ModelAndView("activity");
        //List<Activity> list=activityServiceImpl.GetAllActivity();
        mv.addObject("pageUtil",pageUtil);
        return mv;
    }
    @RequestMapping("AddActivity")
    public String AddActivity(Activity activity){
        activityServiceImpl.AddActivity(activity);
        return "redirect:/activity";
    }
}
