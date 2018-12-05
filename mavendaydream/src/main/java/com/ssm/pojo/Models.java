package com.ssm.pojo;

public class Models {
    private Integer model_id;
    private String model_name;
    private String model_type;
    private Integer fid;
    private String model_status;
    private String url;

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getModel_status() {
        return model_status;
    }

    public void setModel_status(String model_status) {
        this.model_status = model_status;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Models{" +
                "model_id=" + model_id +
                ", model_name='" + model_name + '\'' +
                ", model_type='" + model_type + '\'' +
                ", fid=" + fid +
                ", model_status='" + model_status + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Models() {
    }

    public Models(Integer model_id, String model_name, String model_type, Integer fid, String model_status, String url) {
        this.model_id = model_id;
        this.model_name = model_name;
        this.model_type = model_type;
        this.fid = fid;
        this.model_status = model_status;
        this.url = url;
    }
}
