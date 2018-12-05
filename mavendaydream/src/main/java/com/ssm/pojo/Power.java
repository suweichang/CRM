package com.ssm.pojo;

import javax.swing.*;

public class Power {
    private Integer power_id;
    private Integer role_id;
    private Integer model_id;
    private Models models;

    public Power(Integer power_id, Integer role_id, Integer model_id, Models models) {
        this.power_id = power_id;
        this.role_id = role_id;
        this.model_id = model_id;
        this.models = models;
    }

    public Integer getPower_id() {
        return power_id;
    }

    @Override
    public String toString() {
        return "Power{" +
                "power_id=" + power_id +
                ", role_id=" + role_id +
                ", model_id=" + model_id +
                ", models=" + models +
                '}';
    }

    public void setPower_id(Integer power_id) {
        this.power_id = power_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Models getModels() {
        return models;
    }

    public void setModels(Models models) {
        this.models = models;
    }

    public Power() {

    }
}
