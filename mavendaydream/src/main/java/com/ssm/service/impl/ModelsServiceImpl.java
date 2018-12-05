package com.ssm.service.impl;

import com.ssm.dao.ModelsDao;
import com.ssm.pojo.ModelUpdate;
import com.ssm.pojo.Models;
import com.ssm.service.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ModelsServiceImpl implements ModelsService {
    @Autowired
    private ModelsDao modelsDao;
    @Override
    public Map<Models,List<Models>> getAllModels() {
        List<Models> list=modelsDao.getParentModels();
        Map<Models, List<Models>> maps=new HashMap<Models, List<Models>>();
        for(int i=0;i<list.size();i++){
            List<Models> list1=modelsDao.getModelsByfid(list.get(i).getModel_id());
            maps.put(list.get(i),list1);
        }
        return maps;
    }

    @Override
    public boolean updateModelStatus(Integer model_id, String model_status) {
        ModelUpdate modelUpdate=new ModelUpdate(model_id,model_status);
        if(modelsDao.updateModelStatus(modelUpdate)){
            return true;
        }
        return false;
    }

    @Override
    public Models getModelByid(Integer model_id) {
        return modelsDao.getModelsByid(model_id);
    }

    @Override
    public Models getModelByName(String model_name) {
        return modelsDao.getModelsByName(model_name);
    }

    @Override
    public boolean updateModel(Models models) {

        return modelsDao.updateModel(models);
    }
    @Override
    public List<Models> getParentModel() {
        return modelsDao.getParentModels();
    }

    @Override
    public List<Models> getParentModelStatus() {
        return modelsDao.getParentModelsStatus();
    }

    @Override
    public boolean addParentModel(Models models) {

        return modelsDao.insertParentModel(models);
    }

    @Override
    public boolean addChildModel(Models models) {

        return modelsDao.insertChildModel(models);
    }
}
