package com.ssm.handler;

import com.ssm.pojo.Grade;
import com.ssm.pojo.Review;
import com.ssm.pojo.Student;
import com.ssm.service.GradeService;
import com.ssm.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class GradeHandler {
    @Autowired
    private GradeService gradeServiceImpl;

    @Autowired
    private ReviewService reviewServiceImpl;
    @RequestMapping("AddGrade")
    public String AddGrade(HttpServletRequest request){
        List<Grade> list=new ArrayList<Grade>();

        int review_id=0;
        String[] review_ids=request.getParameterValues("review_id");
        String[] student_ids=request.getParameterValues("student_id");
        String[] grade_scores=request.getParameterValues("grade_score");
        for (int i=0;i<review_ids.length;i++){
            int grade_score=0;
            if(grade_scores[i]!=null && !grade_scores[i].isEmpty()){
                System.out.println("grade_scores[i]"+grade_scores[i]);
                grade_score=Integer.parseInt(grade_scores[i]);
            }
            review_id=Integer.parseInt(review_ids[i]);
            Grade grade=new Grade(Integer.parseInt(review_ids[i]),Integer.parseInt(student_ids[i]),grade_score);
            list.add(grade);
            System.out.println(grade);
        }

        System.out.println("list:"+list);
        gradeServiceImpl.insertBatch(list);
        reviewServiceImpl.ChangReviewStatus(review_id);
        return "redirect:/review";
    }
}
