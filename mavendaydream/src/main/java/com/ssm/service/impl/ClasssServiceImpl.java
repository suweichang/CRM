package com.ssm.service.impl;

import com.ssm.dao.ClasssDao;
import com.ssm.pojo.Classs;
import com.ssm.pojo.Teacher;
import com.ssm.service.ClasssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasssServiceImpl implements ClasssService {
    @Autowired
    private ClasssDao classsDao;
    @Override
    public Classs GetClassById() {
        return classsDao.GetClassById();
    }

    @Override
    public List<Classs> GetAllClasss() {
        return classsDao.GetAllClasss();
    }

    @Override
    public Teacher getTeaByTeaid(Integer id) {
        return classsDao.getTeaByTeaid(id);
    }
}
