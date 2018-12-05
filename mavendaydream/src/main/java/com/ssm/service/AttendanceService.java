package com.ssm.service;

import com.ssm.pojo.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAttList();
    int addAtt(Attendance att);
    int updateAtt(Attendance att);
    //根据id查询数据
    Attendance getAttById(int id);
}
