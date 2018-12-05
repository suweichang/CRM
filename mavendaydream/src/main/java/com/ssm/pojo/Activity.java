package com.ssm.pojo;

import java.sql.Timestamp;

public class Activity extends PageUtil {
    private Integer activity_id;
    private Integer class_id;
    private Classs classs;
    private String activity_name;
    private String activity_loc;
    private Timestamp activity_time;
    private Integer teacher_id;
    private Teacher teacher;

    public Activity(Integer activity_id, Integer class_id, Classs classs, String activity_name, String activity_loc, Timestamp activity_time, Integer teacher_id, Teacher teacher) {
        this.activity_id = activity_id;
        this.class_id = class_id;
        this.classs = classs;
        this.activity_name = activity_name;
        this.activity_loc = activity_loc;
        this.activity_time = activity_time;
        this.teacher_id = teacher_id;
        this.teacher = teacher;
    }

    public Activity(Integer class_id, Classs classs, String activity_name, String activity_loc, Timestamp activity_time, Integer teacher_id, Teacher teacher) {
        this.class_id = class_id;
        this.classs = classs;
        this.activity_name = activity_name;
        this.activity_loc = activity_loc;
        this.activity_time = activity_time;
        this.teacher_id = teacher_id;
        this.teacher = teacher;
    }

    public Activity() {
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_loc() {
        return activity_loc;
    }

    public void setActivity_loc(String activity_loc) {
        this.activity_loc = activity_loc;
    }

    public Timestamp getActivity_time() {
        return activity_time;
    }

    public void setActivity_time(Timestamp activity_time) {
        this.activity_time = activity_time;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity_id=" + activity_id +
                ", class_id=" + class_id +
                ", classs=" + classs +
                ", activity_name='" + activity_name + '\'' +
                ", activity_loc='" + activity_loc + '\'' +
                ", activity_time=" + activity_time +
                ", teacher_id=" + teacher_id +
                ", teacher=" + teacher +
                '}';
    }
}
