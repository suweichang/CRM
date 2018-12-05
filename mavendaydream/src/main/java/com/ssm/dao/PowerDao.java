package com.ssm.dao;

import com.ssm.pojo.AddPower;
import com.ssm.pojo.Power;

import java.util.*;

public interface PowerDao {
    List<Power> getPowers(int role_id);
    boolean deletepower(Integer role_id);
    boolean addPower(AddPower addPower);
}
