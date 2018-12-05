package com.ssm.pojo;

public class AddPower {
    private Integer role_id;
    private Integer model_id;

    public AddPower(Integer role_id, Integer model_id) {
        this.role_id = role_id;
        this.model_id = model_id;
    }

    public AddPower() {
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

    @Override
    public String toString() {
        return "addPower{" +
                "role_id=" + role_id +
                ", model_id=" + model_id +
                '}';
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }
}
