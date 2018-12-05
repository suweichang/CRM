package com.ssm.pojo;

public class Classs {
    private Integer class_id;
    private String class_name;
    private Integer teacher_id;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Classs() {
    }

    public Classs(Integer class_id, String class_name, Integer teacher_id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Classs{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", teacher_id=" + teacher_id +
                '}';
    }
}
