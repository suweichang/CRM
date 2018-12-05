package com.ssm.service;

import com.ssm.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> GetAllTeachers();
    Teacher GetTeacherById();
}
