package com.ssm.dao;

import com.ssm.pojo.ModelUpdate;
import com.ssm.pojo.Models;

import java.util.*;

public interface ModelsDao {
    Models getModelsByid(Integer model_id);
    List<Models> getModelsByfid(Integer fid);
    List<Models> getModelsByfidStatus(Integer fid);
    List<Models> getParentModels();
    List<Models> getParentModelsStatus();
    boolean updateModelStatus(ModelUpdate modelUpdate);
    boolean updateModel(Models models);
    boolean insertParentModel(Models models);
    boolean insertChildModel(Models models);
    Models getModelsByName(String model_name);
}
