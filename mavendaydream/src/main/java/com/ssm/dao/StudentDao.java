package com.ssm.dao;

import com.ssm.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {
    //增加学员
    int addStu(Student stu);
    //获取所有数据
    List<Student> getStuList();
    //修改信息
    int updateStu(Student stu);
    //根据id查询数据
    Student getStuById(int id);
    //根据姓名查询数据
    Student getStuByName(String stuName);
    //根据班级查询学员
    List<Student> getStuByClass(int classId);
    //通过id删除学员
    int delStuById(int id);
}
