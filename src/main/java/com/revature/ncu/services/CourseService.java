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
}
