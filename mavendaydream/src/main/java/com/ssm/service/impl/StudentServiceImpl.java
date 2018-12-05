package com.ssm.service.impl;

import com.ssm.dao.StudentDao;
import com.ssm.pojo.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public int addStu(Student stu) {
        return studentDao.addStu(stu);
    }

    @Override
    public List<Student> getStuList() {
        return studentDao.getStuList();
    }

    @Override
    public int updateStu(Student stu) {
        return studentDao.updateStu(stu);
    }

    @Override
    public Student getStuById(int id) {
        return studentDao.getStuById(id);
    }

    @Override
    public Student getStuByName(String stuName) {
        return studentDao.getStuByName(stuName);
    }

    @Override
    public List<Student> getStuByClass(int classId) {
        return studentDao.getStuByClass(classId);
    }

    @Override
    public int delStuById(int id) {
        return studentDao.delStuById(id);
    }
}
