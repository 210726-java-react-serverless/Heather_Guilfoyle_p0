package com.revature.ncu.services;

import com.revature.ncu.models.Course;
import com.revature.ncu.models.UserSchedule;
import com.revature.ncu.repositories.CourseRepository;
import com.revature.ncu.repositories.UserCoursesRepository;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepo;
    private final UserCoursesRepository uCourseRepo;

    public CourseService(CourseRepository courseRepo,UserCoursesRepository uCourseRepo){
        this.courseRepo = courseRepo;
        this.uCourseRepo = uCourseRepo;
    }

    public Course register(Course newCourse){
        return courseRepo.save(newCourse);
    }

    public UserSchedule register(UserSchedule newSchedule){
        return uCourseRepo.save(newSchedule);
    }

    public Course search(String courseID){
        Course foundCourse = courseRepo.findByCourseID(courseID);
        return foundCourse;
    }
    public UserSchedule searchCourseToDelete(String courseID) {
        UserSchedule findCourse = uCourseRepo.findByCourseID(courseID);
        return findCourse;
    }

    public Course delete(Course course){
        Course removerCourse = courseRepo.removeCourse(course.getCourseID());
        return removerCourse;
    }

    public Course update(Course course, Course newCourseInfo){
        Course updateCourse = courseRepo.updateCourse(course, newCourseInfo);
        return updateCourse;
    }

    public List<Course> viewAll() {
        List<Course> courseList = courseRepo.findAll();
        for (Course course : courseList) {
            System.out.println(course);
        }
        return null;
    }

    public List<UserSchedule> view(String username){
        List<UserSchedule> scheduleList = uCourseRepo.findSchedule(username);
        for(UserSchedule schedule : scheduleList) {
            System.out.println(schedule);
        }
        return null;
    }



}
