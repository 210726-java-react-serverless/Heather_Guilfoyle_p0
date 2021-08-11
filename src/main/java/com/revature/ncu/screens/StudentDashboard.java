package com.revature.ncu.screens;

import com.revature.ncu.models.Course;
import com.revature.ncu.models.UserSchedule;
import com.revature.ncu.services.CourseService;
import com.revature.ncu.util.ScreenRouter;
import com.revature.ncu.util.UserSession;

import java.io.BufferedReader;

public class StudentDashboard extends Screens {

    private final CourseService courseService;
    private final UserSession session;

    public StudentDashboard(BufferedReader consoleReader, ScreenRouter router, UserSession session, CourseService courseService) {
        super("StudentDashboard", "/sdashboard", consoleReader, router);
        this.session = session;
        this.courseService = courseService;
    }

    @Override
    public void render() throws Exception {
        String menu = "\nWelcome " + session.getCurrentUser().getFirstName() + "!\n"+ //would like to add username to the welcome need to figure out how to read that off the login
                "Please type the number of one of the following options.\n" +
                "1) View all courses\n" +
                "2) Register for new course\n" +
                "3) View Your Schedule\n" +
                "4) Remove course from Schedule\n" +
                "5) Log out\n" +
                "> ";

        System.out.print(menu);

        String userSelection = consoleReader.readLine();

        switch(userSelection){

            case "1":
                courseService.viewAll();
                break;
            case "2":
                System.out.print("Type the courseID for the course you would like to add. \n" +
                        ">");
                Course courseToAdd = courseService.search(consoleReader.readLine());
                UserSchedule newSchedule = new UserSchedule(courseToAdd, session.getCurrentUser().getUsername());
                System.out.println(newSchedule);

                courseService.register(newSchedule);
                System.out.println("Success");
                router.navigate("/sdashboard");
                break;
            case "3":
                courseService.view(session.getCurrentUser().getUsername());
                break;
            case "4":
                System.out.print("type the courseID for the course you would like to remove. \n" +
                        ">");
                UserSchedule courseToRemove = courseService.searchCourseToDelete(session.getCurrentUser().getUsername(), consoleReader.readLine());
                System.out.println(courseToRemove);
                System.out.print("\nPlease type in the courseID again to confirm or press 'b' to go back. \n" + ">");
                String selection = consoleReader.readLine();
                if(selection.equals("b")) {
                    router.navigate("/sdashboard");
                    return;
                }
                courseService.delete(session.getCurrentUser().getUsername(), selection);

                break;
            case "5":
                System.out.print("Navigating back to Welcome Screen");
                router.navigate("/welcome");
        }
    }
}

