package com.ssm.service;

import com.ssm.pojo.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeService {
    Integer insertBatch(List<Grade> list);
    List<Grade> FindGradesByReviewId(int review_id);
}
