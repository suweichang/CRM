package com.ssm.dao;

import com.ssm.pojo.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeDao {
    Integer insertBatch(List<Grade> list);
    List<Grade> FindGradesByReviewId(@Param("review_id") int review_id);
}
