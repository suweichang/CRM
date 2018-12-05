package com.ssm.pojo;

import java.sql.Timestamp;

public class Review {
    private Integer review_id;
    private String review_name;
    private Integer class_id;

    private Classs classs;
    private Timestamp ctime;
    private Integer teacher_id;
    private Teacher teacher;
    private String review_status;

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
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

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
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

    public String getReview_status() {
        return review_status;
    }

    public void setReview_status(String review_status) {
        this.review_status = review_status;
    }

    public Review(Integer review_id, String review_name, Integer class_id, Classs classs, Timestamp ctime, Integer teacher_id, Teacher teacher, String review_status) {
        this.review_id = review_id;
        this.review_name = review_name;
        this.class_id = class_id;
        this.classs = classs;
        this.ctime = ctime;
        this.teacher_id = teacher_id;
        this.teacher = teacher;
        this.review_status = review_status;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", review_name='" + review_name + '\'' +
                ", class_id=" + class_id +
                ", classs=" + classs +
                ", ctime=" + ctime +
                ", teacher_id=" + teacher_id +
                ", teacher=" + teacher +
                ", review_status='" + review_status + '\'' +
                '}';
    }
}
