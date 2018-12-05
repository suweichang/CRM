package com.ssm.service.impl;

import com.ssm.dao.LogsDao;
import com.ssm.pojo.Logs;
import com.ssm.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsDao logsDao;
    @Override
    public boolean addLogs(Logs logs) {
        return logsDao.addLogs(logs);
    }

    @Override
    public List<Logs> getAllLogs() {
        return logsDao.getAllLogs();
    }
}
