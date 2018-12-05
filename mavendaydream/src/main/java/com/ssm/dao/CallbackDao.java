package com.ssm.dao;

import com.ssm.pojo.Callback;

import java.util.List;

public interface CallbackDao {
    List<Callback> getCbList();
    int addCb(Callback cb);
    int updateCb(Callback cb);
    //根据id查询数据
    Callback getCbById(int id);
}
