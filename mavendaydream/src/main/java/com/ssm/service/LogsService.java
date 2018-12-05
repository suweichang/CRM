package com.ssm.service;

import com.ssm.pojo.Logs;
import java.util.*;
public interface LogsService {
    boolean addLogs(Logs logs);
    List<Logs> getAllLogs();
}
