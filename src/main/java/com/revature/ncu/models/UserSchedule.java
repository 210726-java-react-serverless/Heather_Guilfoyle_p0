package com.revature.ncu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSchedule {

    private String userName;
    private String courseID;
    private String courseName;
    private String meetDay;
    private String meetTime;

    public UserSchedule(String userName, String courseID, String courseName,  String meetDay, String meetTime) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.meetDay = meetDay;
        this.meetTime = meetTime;
    }

    //for Jackson
    public UserSchedule(){
        super();
    }

    public UserSchedule(Course course, String userName){
        this.userName = userName;
        this.courseID = course.getCourseID();
        this.courseName = course.getCourseName();
        this.meetDay = course.getMeetDay();
        this.meetTime = course.getMeetTime();

    }

    public String getUserName() {
        return userName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMeetDay() {
        return meetDay;
    }

    public void setMeetDay(String meetDay) {
        this.meetDay = meetDay;
    }

    public String getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(String meetTime) {
        this.meetTime = meetTime;
    }

    @Override
    public String toString() {
        return "UserSchedule{" +
                "userName='" + userName + '\'' +
                ", courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", meetDay='" + meetDay + '\'' +
                ", meetTime='" + meetTime + '\'' +
                '}';
    }
}
