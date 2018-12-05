package com.ssm.pojo;

public class MonthInfo {

    private Integer nodones;
    private Integer nodoor;
    private Integer hasdoor;
    private Integer mnodone;
    private Integer mhasdone;

    @Override
    public String toString() {
        return "MonthInfo{" +
                "nodones=" + nodones +
                ", nodoor=" + nodoor +
                ", hasdoor=" + hasdoor +
                ", mnodone=" + mnodone +
                ", mhasdone=" + mhasdone +
                '}';
    }

    public Integer getNodones() {
        return nodones;
    }

    public void setNodones(Integer nodones) {
        this.nodones = nodones;
    }

    public Integer getNodoor() {
        return nodoor;
    }

    public void setNodoor(Integer modoor) {
        this.nodoor = modoor;
    }

    public Integer getHasdoor() {
        return hasdoor;
    }

    public void setHasdoor(Integer hasdoor) {
        this.hasdoor = hasdoor;
    }

    public Integer getMnodone() {
        return mnodone;
    }

    public void setMnodone(Integer mnodone) {
        this.mnodone = mnodone;
    }

    public Integer getMhasdone() {
        return mhasdone;
    }

    public void setMhasdone(Integer mhasdone) {
        this.mhasdone = mhasdone;
    }
}
