package com.ssm.pojo;
import java.util.*;
public class Rolees {
    private Integer role_id;
    private String role_name;

    public Rolees() {
    }

    @Override
    public String toString() {
        return "Rolees{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_status='" + role_status + '\'' +
                '}';
    }

    public Rolees(Integer role_id, String role_name, String role_status) {
        this.role_id = role_id;
        this.role_name = role_name;

        this.role_status = role_status;
    }

    private String role_status;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_status() {
        return role_status;
    }

    public void setRole_status(String role_status) {
        this.role_status = role_status;
    }
}
