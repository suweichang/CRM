package com.ssm.dao;

import com.ssm.pojo.Classs;
import com.ssm.pojo.Teacher;

import java.util.List;

public interface ClasssDao {
    Classs GetClassById();
    List<Classs> GetAllClasss();
    //通过老师id查找老师姓名
    Teacher getTeaByTeaid(Integer id);
}
