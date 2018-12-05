package com.ssm.service;

import com.ssm.pojo.Customer;
import com.ssm.pojo.Month;
import com.ssm.pojo.MonthInfo;
import com.ssm.pojo.Notice;

import java.util.List;

public interface IndexsService {

    List<Month> getCustomerMonth();

    List<Notice> getNotice();

    List<MonthInfo> getMonthInfo();

    List<Customer> getCustomerDone();

    List<Customer> getCustomerReady();
}
