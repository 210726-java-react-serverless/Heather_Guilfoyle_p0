package com.revature.ncu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    private String courseID;
    private String courseName;
    private String courseDescription;
    private String courseTeacher;
    private String meetDay;
    private String meetTime;

    /**
     * Constructor for what the Faculty Screen will when making a new course.
     * */
    public Course(String courseID, String courseName, String courseDescription, String courseTeacher, String meetDay, String meetTime){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseTeacher = courseTeacher;
        this.meetDay = meetDay;
        this.meetTime = meetTime;

    }

    //for Jackson
    public Course() {
        super();
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

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
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
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", meetDay='" + meetDay + '\'' +
                ", meetTime='" + meetTime + '\'' +
                '}';
    }
}
