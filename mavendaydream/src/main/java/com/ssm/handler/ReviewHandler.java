package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Grade;
import com.ssm.pojo.Review;
import com.ssm.pojo.Student;
import com.ssm.service.GradeService;
import com.ssm.service.ReviewService;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReviewHandler {
    @Autowired
    private ReviewService reviewServiceImpl;
    @Autowired
    private StudentService studentServiceImpl;
    @Autowired
    private GradeService gradeServiceImpl;

    @RequestMapping("review")
    public ModelAndView GetAllReview(HttpServletRequest request){
        int sPage;
        String pageIndex=request.getParameter("pageIndex");
        if (pageIndex!=null){
            sPage=Integer.parseInt(pageIndex);
        }else{
            sPage=1;
        }
        ModelAndView mv=new ModelAndView("review");
        PageHelper.startPage(sPage,5);
        List<Review> reviewList=reviewServiceImpl.GetAllReview();
        PageInfo<Review> reviewpageInfo=new PageInfo<>(reviewList);
        mv.addObject("reviewpageInfo",reviewpageInfo);
        return mv;
    }
    @RequestMapping("addreview")
    public String AddReview(Review review){
        //System.out.println(review);
        reviewServiceImpl.AddReview(review);
        return "redirect:/review";
    }

    @RequestMapping("takereview")
    public String takereview(HttpServletRequest request){
        String class_id=request.getParameter("class_id");
        String review_id=request.getParameter("review_id");

        String op=request.getParameter("op");
        if (op!=null){
            List<Grade> Grades=gradeServiceImpl.FindGradesByReviewId(Integer.parseInt(review_id));
            System.out.println(Grades);
            request.setAttribute("Grades",Grades);
        }
        if(class_id!=null && review_id!=null){
            System.out.println(class_id);
            List<Student> studentList=studentServiceImpl.getStuByClass(Integer.parseInt(class_id));
            request.setAttribute("studentList",studentList);
            Review review=reviewServiceImpl.GetReviewById(Integer.parseInt(review_id));
            request.setAttribute("review",review);
        }
        return "takereview";
    }
}
