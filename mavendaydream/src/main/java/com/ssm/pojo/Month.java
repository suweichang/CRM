package com.ssm.pojo;

public class Month {

    private String ctime;
    private Integer cmonth;

    @Override
    public String toString() {
        return "Month{" +
                "ctime='" + ctime + '\'' +
                ", cmonth=" + cmonth +
                '}';
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public Integer getCmonth() {
        return cmonth;
    }

    public void setCmonth(Integer cmonth) {
        this.cmonth = cmonth;
    }
}
