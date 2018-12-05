package com.ssm.service.impl;

import com.ssm.dao.IndexsDao;
import com.ssm.pojo.Customer;
import com.ssm.pojo.Month;
import com.ssm.pojo.MonthInfo;
import com.ssm.pojo.Notice;
import com.ssm.service.IndexsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexsServiceImple implements IndexsService {

    @Autowired
    private IndexsDao indexsDaoDao;


    @Override
    public List<Month> getCustomerMonth() {
        return indexsDaoDao.getCustomerMonth();
    }

    @Override
    public List<Notice> getNotice() {
        return indexsDaoDao.getNotice();
    }

    @Override
    public List<MonthInfo> getMonthInfo() {
        return indexsDaoDao.getMonthInfo();
    }

    @Override
    public List<Customer> getCustomerDone() {
        return indexsDaoDao.getCustomerDone();
    }

    @Override
    public List<Customer> getCustomerReady() {
        return indexsDaoDao.getCustomerReady();
    }
}
