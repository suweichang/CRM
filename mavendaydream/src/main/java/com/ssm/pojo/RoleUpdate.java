package com.ssm.pojo;

public class RoleUpdate {
    private Integer role_id;
    private String status;

    public RoleUpdate() {
    }

    public RoleUpdate(Integer role_id, String status) {
        this.role_id = role_id;
        this.status = status;

    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoleUpdate{" +
                "role_id=" + role_id +
                ", status='" + status + '\'' +
                '}';
    }
}
