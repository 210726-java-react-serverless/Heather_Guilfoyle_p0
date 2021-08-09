package com.revature.ncu.screens;

import com.revature.ncu.models.Course;

import com.revature.ncu.services.CourseService;
import com.revature.ncu.util.ScreenRouter;
import com.revature.ncu.util.UserSession;

import java.io.BufferedReader;

public class FacultyDashboard extends Screens {

    private final CourseService courseService;
    private final UserSession session;

    public FacultyDashboard(BufferedReader consoleReader, ScreenRouter router, CourseService courseService, UserSession session){
        super("FacultyDashboard", "/fdashboard", consoleReader, router);
        this.courseService = courseService;
        this.session = session;
    }

    @Override
    public void render() throws Exception {


        String menu = "\nWelcome " + session.getCurrentUser().getFirstName() + "!\n" + //would like to add username to the welcome need to figure out how to read that off the login
                "Please type the number of one of the following options.\n" +
                "1) Add new Course\n" +
                "2) Edit Courses\n" +
                "3) Remove Course\n" +
                "4) Log out\n" +
                "> ";

        System.out.print(menu);

        String userSelection = consoleReader.readLine(); //without this line the screen renders as a broken loop

        switch (userSelection) {

            case "1":
                System.out.println("\nAdd a new course!");

                System.out.print("Course ID: ");
                String courseID = consoleReader.readLine();

                System.out.print("Course Name: ");
                String courseName = consoleReader.readLine();

                System.out.print("Course Description: ");
                String courseDescription = consoleReader.readLine();

                System.out.print("Professor: ");
                String courseTeacher = consoleReader.readLine();

                System.out.print("Meet Days: ");
                String meetDay = consoleReader.readLine();

                System.out.print("Time: ");
                String meetTime = consoleReader.readLine();

                Course newCourse = new Course(courseID, courseName, courseDescription, courseTeacher, meetDay, meetTime);
                System.out.println(newCourse);

                //TODO Validate Registration is successful. If true System.out.println "Success." and navigate to dashboard.
                courseService.register(newCourse);
                System.out.println("Success");
                router.navigate("/fdashboard");

                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Now Exiting");
                System.exit(0); //TODO Needs to be fixed. This is apparently ugly.
                break;
            default:
                System.out.println("Please pick a number between 1 - 3");

        }

    }

}
