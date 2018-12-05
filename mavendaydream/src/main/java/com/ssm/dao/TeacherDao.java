package com.ssm.dao;

import com.ssm.pojo.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> GetAllTeachers();
    Teacher GetTeacherById();
}
