package com.ssm.dao;

import com.ssm.pojo.Logs;

import java.util.*;

public interface LogsDao {
    boolean addLogs(Logs logs);
    List<Logs> getAllLogs();
}
