package com.revature.ncu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSchedule {

    //@JsonProperty("username")
    private String username;
    private String courseID;
    private String courseName;
    private String meetDay;
    private String meetTime;

    public UserSchedule(String username, String courseID, String courseName, String meetDay, String meetTime) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.meetDay = meetDay;
        this.meetTime = meetTime;
    }

    //for Jackson
    public UserSchedule(){
        super();
    }

    public UserSchedule(Course course, String username){
        this.username = username;
        this.courseID = course.getCourseID();
        this.courseName = course.getCourseName();
        this.meetDay = course.getMeetDay();
        this.meetTime = course.getMeetTime();

    }

    public String getUsername() {
        return username;
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
                "userName='" + username + '\'' +
                ", courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", meetDay='" + meetDay + '\'' +
                ", meetTime='" + meetTime + '\'' +
                '}';
    }
}
