package com.revature.ncu.screens;

import com.revature.ncu.models.Course;

import com.revature.ncu.services.CourseService;
import com.revature.ncu.util.ScreenRouter;
import com.revature.ncu.util.UserSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public class FacultyDashboard extends Screens {

    private final CourseService courseService;
    private final UserSession session;
    private final Logger logger = LogManager.getLogger(FacultyDashboard.class);

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
                "4) View Course Catalog\n" +
                "5) Log out\n" +
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

                courseService.register(newCourse);
                System.out.println("Success");
                logger.info("course successfully added");
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
                System.out.print("\nPlease type in the courseID again to confirm or press \"b\" to go back. \n" + ">");
                String selection = consoleReader.readLine();
                if(selection.equalsIgnoreCase("b")) {
                    router.navigate("/fdashboard");
                    return;
                }
                courseService.delete(courseToRemove);
                logger.info("course deleted");
                break;

            case "4":
                courseService.viewAll();
                break;
            case "5":
                System.out.print("Navigating back to Welcome Screen");
                router.navigate("/welcome");
            default:
                System.out.println("Please pick a number between 1 - 5");

        }

    }
    //moved down here because I didn't want a switch case inside a switch case.
    /**
     * updateScreen is a void method that holds all the logic for a user to update specific fields of a course
     * It connects to the UserRepository through the user Service method
     * */
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
               logger.debug("user did not select one of the working choices");
           }
       } catch (Exception e){
           e.printStackTrace();
       }

    }

}
