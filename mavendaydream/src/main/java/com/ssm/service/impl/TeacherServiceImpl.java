package com.ssm.service.impl;

import com.ssm.dao.TeacherDao;
import com.ssm.pojo.Teacher;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> GetAllTeachers() {
        return teacherDao.GetAllTeachers();
    }

    @Override
    public Teacher GetTeacherById() {
        return teacherDao.GetTeacherById();
    }
}
