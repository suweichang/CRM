package com.ssm.dao;

import com.ssm.pojo.Activity;

import java.util.List;

public interface ActivityDao {
    List<Activity> GetAllActivity(int index);
    Integer pagecount();
    Integer AddActivity(Activity activity);
}
