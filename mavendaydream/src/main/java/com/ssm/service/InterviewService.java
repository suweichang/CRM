package com.ssm.service;

import com.ssm.pojo.Interview;

import java.util.List;

public interface InterviewService {
    List<Interview> getInteList();
    int addInte(Interview interview);
    int updateInte(Interview interview);
    Interview getIntById(int id);
}
