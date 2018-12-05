package com.ssm.pojo;

import java.sql.Timestamp;

public class Notice {
    private Integer notice_id;
    private String notice_title;
    private String notice_content;
    private String user_id;
    private Timestamp notice_time;

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Timestamp getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(Timestamp notice_time) {
        this.notice_time = notice_time;
    }

    public Notice(Integer notice_id, String notice_title, String notice_content, String user_id, Timestamp notice_time) {
        this.notice_id = notice_id;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.user_id = user_id;
        this.notice_time = notice_time;
    }

    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice_title='" + notice_title + '\'' +
                ", notice_content='" + notice_content + '\'' +
                ", user_id='" + user_id + '\'' +
                ", notice_time=" + notice_time +
                '}';
    }
}
