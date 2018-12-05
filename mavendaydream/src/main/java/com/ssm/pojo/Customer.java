package com.ssm.pojo;

public class Customer {

    private Integer customer_id;
    private String customer_name;
    private String customer_phone;
    private String customer_school;
    private String customer_major;
    private String customer_status;

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                ", customer_school='" + customer_school + '\'' +
                ", customer_major='" + customer_major + '\'' +
                ", customer_status='" + customer_status + '\'' +
                '}';
    }

    public String getCustomer_school() {
        return customer_school;
    }

    public void setCustomer_school(String customer_school) {
        this.customer_school = customer_school;
    }

    public String getCustomer_major() {
        return customer_major;
    }

    public void setCustomer_major(String customer_major) {
        this.customer_major = customer_major;
    }

    public String getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
}
