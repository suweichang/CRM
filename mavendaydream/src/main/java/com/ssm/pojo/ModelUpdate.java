package com.ssm.pojo;

public class ModelUpdate {
    private Integer model_id;
    private String model_status;

    public ModelUpdate(Integer model_id, String mdoel_status) {
        this.model_id = model_id;
        this.model_status = mdoel_status;
    }

    public Integer getModel_id() {
        return model_id;
    }

    @Override
    public String toString() {
        return "ModelUpdate{" +
                "model_id=" + model_id +
                ", mdoel_status='" + model_status + '\'' +
                '}';
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public String getMdoel_status() {
        return model_status;
    }

    public void setMdoel_status(String model_status) {
        this.model_status = model_status;
    }

    public ModelUpdate() {
    }
}
