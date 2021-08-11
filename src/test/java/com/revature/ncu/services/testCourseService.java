package com.revature.ncu.services;

import com.revature.ncu.models.Course;
import com.revature.ncu.repositories.CourseRepository;
import com.revature.ncu.repositories.UserCoursesRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class testCourseService {

    CourseService sut;

    private CourseRepository mockCourseRepo;
    private UserCoursesRepository mockUserCourseRepo;

    @Before
    public void before(){
        mockCourseRepo = mock(CourseRepository.class);
        mockUserCourseRepo = mock(UserCoursesRepository.class);

        sut = new CourseService(mockCourseRepo,mockUserCourseRepo);
    }

    @After
    public void after(){
        sut = null;
    }

    @Test
    public void registerForCourse_ReturnsSuccesfully(){
        //arrange
        Course testCourse = new Course("test","test","test","test","test","test");
        Course returnedCourse = testCourse;
        when(mockCourseRepo.save(any())).thenReturn(returnedCourse);
        //act
         Course test = sut.register(testCourse);
        //assert
        Assert.assertEquals(testCourse, test);
        verify(mockCourseRepo,times(1)).save(any());
    }
}
