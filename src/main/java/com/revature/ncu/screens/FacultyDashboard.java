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
                updateScreen();
                break;

            case "3":
                System.out.print("type the courseID for the course you would like to remove. \n" +
                ">");
                Course courseToRemove = courseService.search(consoleReader.readLine());
                System.out.println(courseToRemove);
               Course courseToRemove2 = courseService.delete(courseToRemove);
                break;
            default:
                System.out.println("Please pick a number between 1 - 3");

        }

    }
    private void updateScreen(){
       try {
           System.out.print("Type the courseID for the course you would like to edit. \n" +
                   ">");
           Course courseToEdit = courseService.search(consoleReader.readLine());
           System.out.println(courseToEdit);
           Course updatedCourse = courseToEdit.getCopy();

           String menu = "\nPlease Select what info you wish to update\n" + //would like to add username to the welcome need to figure out how to read that off the login
                   "1) Course Name\n" +
                   "2) Course Description\n" +
                   "3) Professor\n" +
                   "4) MeetDay\n" +
                   "5) Time\n" +
                   "6) Back to Dashboard" +
                   "> ";
           System.out.print(menu);

           String userSelection = consoleReader.readLine();

           switch (userSelection) {
               case "1":
                   System.out.print("New Course Name\n" + ">");
                   updatedCourse.setCourseName(consoleReader.readLine());
                   courseService.update(courseToEdit, updatedCourse);
                   break;
               case "2":
                   System.out.print("New Course Description\n" + ">");
                   updatedCourse.setCourseDescription(consoleReader.readLine());
                   courseService.update(courseToEdit, updatedCourse);
                   break;
               case "3":
                   System.out.print("New Professor\n" + ">");
                   updatedCourse.setCourseTeacher(consoleReader.readLine());
                   courseService.update(courseToEdit, updatedCourse);
                   break;
               case "4":
                   System.out.print("New Meeting Day\n" + ">");
                   updatedCourse.setMeetDay(consoleReader.readLine());
                   courseService.update(courseToEdit, updatedCourse);
                   break;
               case "5":
                   System.out.print("New Time\n" + ">");
                   updatedCourse.setMeetTime(consoleReader.readLine());
                   courseService.update(courseToEdit, updatedCourse);
                   break;
               case "6":
                   router.navigate("/fdashboard");
                   break;
               default:
               System.out.print("Please pick a number between 1 - 6");
           }
       } catch (Exception e){
           e.printStackTrace();
       }

    }

}
