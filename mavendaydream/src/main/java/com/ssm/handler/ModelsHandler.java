package com.ssm.handler;

import com.ssm.pojo.AddPower;
import com.ssm.pojo.Models;
import com.ssm.pojo.Useres;
import com.ssm.service.ModelsService;
import com.ssm.service.RoleesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
public class ModelsHandler {
    @Autowired
    private ModelsService modelsServiceImpl;
    @Autowired
    private RoleesService roleesServiceImpl;
    @RequestMapping("model")
    public ModelAndView mdoel(){
        ModelAndView mv=new ModelAndView("models");
        Map<Models,List<Models>> maps=modelsServiceImpl.getAllModels();
        mv.addObject("allModels",maps);
        return mv;
    }
    @RequestMapping("updateStatus/{model_id}/{model_status}")
    public String update(@PathVariable(value="model_id") Integer model_id, @PathVariable(value="model_status") String model_status, HttpServletRequest request){
        System.out.println(model_id+model_status);
        modelsServiceImpl.updateModelStatus(model_id,model_status);
        request.getSession().setAttribute("flush","haha");
        return "redirect:/index";
    }
    @RequestMapping("update/{model_id}")
    public ModelAndView update(@PathVariable(value = "model_id") Integer model_id){
        Models models=modelsServiceImpl.getModelByid(model_id);
        ModelAndView mv=new ModelAndView("updateModel");
        mv.addObject("model",models);
        return mv;
    }
    @RequestMapping("updateModel")
    public String updateModel(@Param(value = "model_id") Integer model_id,@Param(value = "model_name") String model_name, @Param(value = "url") String url,HttpServletRequest request){
        Models models=new Models();
        models.setModel_id(model_id);
        models.setModel_name(model_name);
        models.setUrl(url);
        modelsServiceImpl.updateModel(models);
        request.getSession().setAttribute("flush","haha");
        return "redirect:/index";
    }
    @RequestMapping("add")
    public ModelAndView add(){
        ModelAndView mv=new ModelAndView("addModel");
        List<Models> list=modelsServiceImpl.getParentModel();
        mv.addObject("parentModel",list);
        return mv;
    }
    @RequestMapping("addModel")
    public String addModel(@Param(value = "model_name") String model_name,@Param(value = "model_type") String model_type,
                           @Param(value = "url") String url,@Param(value = "fid") Integer fid,HttpServletRequest request){
        Models models=new Models();
        models.setModel_name(model_name);
        models.setUrl(url);
        models.setModel_type(model_type);
        models.setFid(fid);
        if(models.getModel_type().equals("1")){

            modelsServiceImpl.addParentModel(models);
        }
        else{
            modelsServiceImpl.addChildModel(models);
        }
        Useres useres=(Useres) request.getSession().getAttribute("user");
        Models models1=modelsServiceImpl.getModelByName(model_name);
        AddPower addPower=new AddPower(useres.getRole_id(),models1.getModel_id());
        roleesServiceImpl.addPower(addPower);
        request.getSession().setAttribute("flush","haha");
        return "redirect:/index";
    }
}
