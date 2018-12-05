package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Notice;
import com.ssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class NoticeHandler {
    @Autowired
    private NoticeService noticeServiceImpl;
    @RequestMapping("notice")
    public ModelAndView GetAllNotices(HttpServletRequest request){
        String op=request.getParameter("op");
        if (op!=null){
            request.getSession().removeAttribute("notice_title");
            request.getSession().removeAttribute("notice_content");
        }
        String notice_title=request.getParameter("notice_title");
        if (notice_title!=null){
            request.getSession().setAttribute("notice_title",notice_title);
            notice_title="%"+notice_title+"%";
        }
        String notice_content=request.getParameter("notice_content");
        if (notice_content!=null){
            request.getSession().setAttribute("notice_content",notice_content);
            notice_content="%"+notice_content+"%";
        }
        int sPage;
        String pageIndex=request.getParameter("pageIndex");
        if (pageIndex!=null){
            sPage=Integer.parseInt(pageIndex);
        }else{
            sPage=1;
        }
        ModelAndView mv=new ModelAndView("notice");
        PageHelper.startPage(sPage,5);
        List<Notice> noticeList=noticeServiceImpl.GetAllNotices(notice_title,notice_content);
        PageInfo<Notice> noticepageInfo=new PageInfo<>(noticeList);
        mv.addObject("noticepageInfo",noticepageInfo);
        return mv;
    }

    @RequestMapping("AddNotice")
    public String AddActivity(Notice notice){
        //System.out.println("notice:"+notice);
        noticeServiceImpl.AddNotice(notice);
        return "redirect:/notice";
    }

    @RequestMapping("detailnotice")
    public String GetAllNoticeById(HttpServletRequest request){
        String notice_id=request.getParameter("notice_id");
        String op=request.getParameter("op");
        if (op!=null && op.equals("looknotice")){
            request.setAttribute("look","look");
        }else{
            request.setAttribute("update","update");
        }

        if (notice_id!=null){
            request.setAttribute("detailnotice",noticeServiceImpl.GetAllNoticeById(Integer.parseInt(notice_id)));
        }
        return "detailnotice";
    }

    @RequestMapping("deltelnotice")
    public String DelNoticeById(HttpServletRequest request){
        String notice_id=request.getParameter("notice_id");
        if (notice_id!=null){
            noticeServiceImpl.DelNoticeById(Integer.parseInt(notice_id));
        }
        return "redirect:/notice";
    }


    @RequestMapping("UpDAteNotice")
    public String UpDAteNotice(Notice notice){
        //System.out.println("notice:"+notice);
        noticeServiceImpl.UpDAteNotice(notice);
        return "redirect:/notice";
    }

}
