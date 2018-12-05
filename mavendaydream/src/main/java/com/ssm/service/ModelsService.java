package com.ssm.service;

import com.ssm.pojo.Models;


import java.util.*;

public interface ModelsService {
    Map<Models,List<Models>> getAllModels();
    boolean updateModelStatus(Integer model_id, String model_status);
    Models getModelByid(Integer model_id);
    Models getModelByName(String model_name);
    boolean updateModel(Models models);
    List<Models> getParentModel();
    List<Models> getParentModelStatus();
    boolean addParentModel(Models models);
    boolean addChildModel(Models models);
}
