package com.ssm.pojo;

import java.awt.*;
import java.sql.Timestamp;

public class Logs {
    private Integer log_id;
    private Integer user_id;
    private String operation;

    private Timestamp operation_time;
    private String ip_address;
    private Useres useres;

    @Override
    public String toString() {
        return "Logs{" +
                "log_id=" + log_id +
                ", user_id=" + user_id +
                ", operation='" + operation + '\'' +
                ", operation_time=" + operation_time +
                ", ip_address='" + ip_address + '\'' +
                ", useres=" + useres +
                '}';
    }

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Timestamp getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Timestamp operation_time) {
        this.operation_time = operation_time;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Useres getUseres() {
        return useres;
    }

    public void setUseres(Useres useres) {
        this.useres = useres;
    }

    public Logs() {
    }

    public Logs(Integer log_id, Integer user_id, String operation, Timestamp operation_time, String ip_address, Useres useres) {
        this.log_id = log_id;
        this.user_id = user_id;
        this.operation = operation;
        this.operation_time = operation_time;
        this.ip_address = ip_address;
        this.useres = useres;
    }
}
