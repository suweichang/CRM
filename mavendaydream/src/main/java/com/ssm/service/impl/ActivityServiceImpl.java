package com.ssm.service.impl;

import com.ssm.dao.ActivityDao;
import com.ssm.pojo.Activity;
import com.ssm.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    //获取总页数
    @Override
    public Integer pagecount(){
        return activityDao.pagecount();
    }

    @Override
    public Integer AddActivity(Activity activity) {
        return activityDao.AddActivity(activity);
    }

    @Override
    public List<Activity> GetAllActivity(int index) {
        return activityDao.GetAllActivity(index);
    }
}
