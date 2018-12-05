package com.ssm.service.impl;

import com.ssm.dao.GradeDao;
import com.ssm.pojo.Grade;
import com.ssm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;
    @Override
    public Integer insertBatch(List<Grade> list) {
        return gradeDao.insertBatch(list);
    }

    @Override
    public List<Grade> FindGradesByReviewId(int review_id) {
        return gradeDao.FindGradesByReviewId(review_id);
    }
}
