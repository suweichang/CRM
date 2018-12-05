package com.ssm.service.impl;

import com.ssm.dao.ModelsDao;
import com.ssm.dao.PowerDao;
import com.ssm.dao.UseresDao;
import com.ssm.pojo.Models;
import com.ssm.pojo.Power;
import com.ssm.pojo.Useres;
import com.ssm.service.UseresService;
import com.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UseresServiceImpl implements UseresService {
    @Autowired
    private UseresDao useresDao;
    @Autowired
    private PowerDao powerDao;
    @Autowired
    private ModelsDao modelsDao;
    @Override
    public boolean useresLogin(String username, String password, HttpServletRequest request) {
        Useres useres= useresDao.useresLogin(username);
        if(useres!=null){
            if(useres.getUser_pwd().equals(MD5.md5(password))){
                request.getSession().setAttribute("user",useres);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public Map<Models,List<Models>> getUseresModel(String username) {
        Useres useres=useresDao.useresLogin(username);
        Map<Models,List<Models>> maps=new HashMap<Models,List<Models>>();
        List<Power> list=powerDao.getPowers(useres.getRole_id());
        List<Models> list1=new ArrayList<Models>();
        for (int i=0;i<list.size();i++){
            list1.add(modelsDao.getModelsByid(list.get(i).getModel_id()));
        }
        for (int i=0;i<list1.size();i++){
            if(list1.get(i).getModel_type().equals("1")){
                List<Models> list2=new ArrayList<Models>();
                list2=modelsDao.getModelsByfidStatus(list1.get(i).getModel_id());
                maps.put(list1.get(i),list2);
            }
        }
        return maps;
    }

    @Override
    public Useres getUseresByname(String username) {
        return useresDao.useresLogin(username);
    }

    @Override
    public List<Useres> getAllUser(Integer user_id) {
        return useresDao.getAllUser(user_id);
    }

    @Override
    public boolean updateUser(Useres useres) {
        return useresDao.updateUser(useres);
    }

    @Override
    public boolean updateUsers(Useres useres) {
        return useresDao.updateUsers(useres);
    }

}
