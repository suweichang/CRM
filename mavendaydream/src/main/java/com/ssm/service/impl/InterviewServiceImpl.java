package com.ssm.service.impl;

import com.ssm.dao.InterviewDao;
import com.ssm.pojo.Interview;
import com.ssm.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao dao;
    @Override
    public List<Interview> getInteList() {
        return dao.getInteList();
    }

    @Override
    public int addInte(Interview interview) {
        return dao.addInte(interview);
    }

    @Override
    public int updateInte(Interview interview) {
        return dao.updateInte(interview);
    }

    @Override
    public Interview getIntById(int id) {
        return dao.getIntById(id);
    }
}
