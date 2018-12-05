package com.ssm.pojo;

public class Grade {
    private Integer grade_id;
    private Integer review_id;
    private Integer student_id;
    private Integer grade_score;

    public Grade(Integer grade_id, Integer review_id, Integer student_id, Integer grade_score) {
        this.grade_id = grade_id;
        this.review_id = review_id;
        this.student_id = student_id;
        this.grade_score = grade_score;
    }

    public Grade(Integer review_id, Integer student_id, Integer grade_score) {
        this.review_id = review_id;
        this.student_id = student_id;
        this.grade_score = grade_score;
    }

    public Grade() {
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getGrade_score() {
        return grade_score;
    }

    public void setGrade_score(Integer grade_score) {
        this.grade_score = grade_score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", review_id=" + review_id +
                ", student_id=" + student_id +
                ", grade_score=" + grade_score +
                '}';
    }
}
