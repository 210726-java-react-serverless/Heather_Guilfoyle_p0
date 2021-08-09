package com.revature.ncu.services;

import com.revature.ncu.models.Course;
import com.revature.ncu.repositories.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo){
        this.courseRepo = courseRepo;
    }

    public Course register(Course newCourse){
        return courseRepo.save(newCourse);
    }

    public Course search(String courseID){
        Course foundCourse = courseRepo.findByCourseID(courseID);
        return foundCourse;
    }

    public Course delete(Course course){
        Course removerCourse = courseRepo.removeCourse(course.getCourseID());
        return removerCourse;
    }

    public Course update(Course course, Course newCourseInfo){
        Course updateCourse = courseRepo.updateCourse(course, newCourseInfo);
        return updateCourse;
    }
}
