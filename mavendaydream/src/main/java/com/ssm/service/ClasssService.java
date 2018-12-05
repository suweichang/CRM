package com.ssm.service;

import com.ssm.pojo.Classs;
import com.ssm.pojo.Teacher;

import java.util.List;

public interface ClasssService {
    Classs GetClassById();
    List<Classs> GetAllClasss();
    Teacher getTeaByTeaid(Integer id);
}
