package com.revature.ncu.util;

import com.revature.ncu.repositories.CourseRepository;
import com.revature.ncu.repositories.UserRepository;
import com.revature.ncu.screens.*;
import com.revature.ncu.services.CourseService;
import com.revature.ncu.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        UserSession userSession = new UserSession();
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo, userSession);

        CourseRepository courseRepo = new CourseRepository();
        CourseService courseService = new CourseService(courseRepo);

        router.addScreen(new WelcomeScreen(consoleReader, router));
        router.addScreen(new RegisterScreen(consoleReader,router, userService)); // TODO do that on all the screens that need userService
        router.addScreen(new LoginScreen(consoleReader,router, userService));
        router.addScreen(new StudentDashboard(consoleReader, router, userSession,courseService));
        router.addScreen(new FacultyDashboard(consoleReader, router, courseService, userSession));
    }

    /**
     * This starts the screen at the welcome screen when the app is first started up
     * */
    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        appRunning = false;
        MongoFactory.getInstance().cleanUp();
    }
}
