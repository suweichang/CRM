package com.ssm.pojo;

public class Useres {
    private Integer user_id;
    private String user_name;
    private String user_pwd;
    private Integer role_id;
    private String user_status;
    private Rolees rolees;

    @Override
    public String toString() {
        return "Useres{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", role_id='" + role_id + '\'' +
                ", user_status='" + user_status + '\'' +
                ", rolees=" + rolees +
                '}';
    }

    public Rolees getRolees() {
        return rolees;
    }

    public void setRolees(Rolees rolees) {
        this.rolees = rolees;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Useres() {
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Useres(Integer user_id, String user_name, String user_pwd, Integer role_id, String user_status, Rolees rolees) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.role_id = role_id;
        this.user_status = user_status;
        this.rolees = rolees;
    }
}
