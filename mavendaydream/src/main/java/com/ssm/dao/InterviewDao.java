package com.ssm.dao;

import com.ssm.pojo.Interview;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InterviewDao {
    List<Interview> getInteList();
    int addInte(Interview interview);
    int updateInte(Interview interview);
    //根据id查询数据
    Interview getIntById(int id);
}
