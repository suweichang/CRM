package com.ssm.pojo;

import java.util.Date;

public class Callback {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CALLBACK.CALLBACK_ID
     *
     * @mbg.generated
     */
    private Integer callbackId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CALLBACK.CALLBACK_DATE
     *
     * @mbg.generated
     */
    private Date callbackDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CALLBACK.CALLBACK_CONTENT
     *
     * @mbg.generated
     */
    private String callbackContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CALLBACK.STUDENT_ID
     *
     * @mbg.generated
     */
    private Integer studentId;
    private String studentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CALLBACK.PHOTO
     *
     * @mbg.generated
     */
    private String photo;

    public Callback(Integer callbackId, Date callbackDate, String callbackContent, Integer studentId, String photo) {
        this.callbackId = callbackId;
        this.callbackDate = callbackDate;
        this.callbackContent = callbackContent;
        this.studentId = studentId;
        this.photo = photo;
    }
    public Callback(){}

    @Override
    public String toString() {
        return "Callback{" +
                "callbackId=" + callbackId +
                ", callbackDate=" + callbackDate +
                ", callbackContent='" + callbackContent + '\'' +
                ", studentId=" + studentId +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CALLBACK.CALLBACK_ID
     *
     * @return the value of CALLBACK.CALLBACK_ID
     *
     * @mbg.generated
     */


    public Integer getCallbackId() {
        return callbackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CALLBACK.CALLBACK_ID
     *
     * @param callbackId the value for CALLBACK.CALLBACK_ID
     *
     * @mbg.generated
     */
    public void setCallbackId(Integer callbackId) {
        this.callbackId = callbackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CALLBACK.CALLBACK_DATE
     *
     * @return the value of CALLBACK.CALLBACK_DATE
     *
     * @mbg.generated
     */
    public Date getCallbackDate() {
        return callbackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CALLBACK.CALLBACK_DATE
     *
     * @param callbackDate the value for CALLBACK.CALLBACK_DATE
     *
     * @mbg.generated
     */
    public void setCallbackDate(Date callbackDate) {
        this.callbackDate = callbackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CALLBACK.CALLBACK_CONTENT
     *
     * @return the value of CALLBACK.CALLBACK_CONTENT
     *
     * @mbg.generated
     */
    public String getCallbackContent() {
        return callbackContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CALLBACK.CALLBACK_CONTENT
     *
     * @param callbackContent the value for CALLBACK.CALLBACK_CONTENT
     *
     * @mbg.generated
     */
    public void setCallbackContent(String callbackContent) {
        this.callbackContent = callbackContent == null ? null : callbackContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CALLBACK.STUDENT_ID
     *
     * @return the value of CALLBACK.STUDENT_ID
     *
     * @mbg.generated
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CALLBACK.STUDENT_ID
     *
     * @param studentId the value for CALLBACK.STUDENT_ID
     *
     * @mbg.generated
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CALLBACK.PHOTO
     *
     * @return the value of CALLBACK.PHOTO
     *
     * @mbg.generated
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CALLBACK.PHOTO
     *
     * @param photo the value for CALLBACK.PHOTO
     *
     * @mbg.generated
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}