package com.ssm.dao;

import com.ssm.pojo.Customer;
import com.ssm.pojo.Month;
import com.ssm.pojo.MonthInfo;
import com.ssm.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexsDao {

    List<Notice> getNotice();

    List<Month> getCustomerMonth();

    List<MonthInfo> getMonthInfo();

    List<Customer> getCustomerDone();

    List<Customer> getCustomerReady();

}
