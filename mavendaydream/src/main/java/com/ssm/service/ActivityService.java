package com.ssm.service;

import com.ssm.pojo.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> GetAllActivity(int index);
    Integer pagecount();
    Integer AddActivity(Activity activity);
}
