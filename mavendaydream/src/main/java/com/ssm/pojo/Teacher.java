package com.ssm.pojo;

public class Teacher {
    private Integer teacher_id;
    private String teacher_name;
    private String teacher_status;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_status() {
        return teacher_status;
    }

    public void setTeacher_status(String teacher_status) {
        this.teacher_status = teacher_status;
    }

    public Teacher() {
    }

    public Teacher(Integer teacher_id, String teacher_name, String teacher_status) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_status = teacher_status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_status='" + teacher_status + '\'' +
                '}';
    }
}
