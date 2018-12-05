package com.ssm.service.impl;

import com.ssm.dao.CallbackDao;
import com.ssm.pojo.Callback;
import com.ssm.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CallbackServiceImpl implements CallbackService {
    @Autowired
    private CallbackDao dao;
    @Override
    public List<Callback> getCbList() {
        return dao.getCbList();
    }

    @Override
    public int addCb(Callback cb) {
        return dao.addCb(cb);
    }

    @Override
    public int updateCb(Callback cb) {
        return dao.updateCb(cb);
    }

    @Override
    public Callback getCbById(int id) {
        return dao.getCbById(id);
    }
}
