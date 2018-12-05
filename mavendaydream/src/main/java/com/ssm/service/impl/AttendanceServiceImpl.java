package com.ssm.service.impl;

import com.ssm.dao.AttendanceDao;
import com.ssm.pojo.Attendance;
import com.ssm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao dao;
    @Override
    public List<Attendance> getAttList() {
        return dao.getAttList();
    }

    @Override
    public int addAtt(Attendance att) {
        return dao.addAtt(att);
    }

    @Override
    public int updateAtt(Attendance att) {
        return dao.updateAtt(att);
    }

    @Override
    public Attendance getAttById(int id) {
        return dao.getAttById(id);
    }
}
