package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;
import com.revature.ncu.util.UserSession;

import java.io.BufferedReader;

public class StudentDashboard extends Screens {

    private final UserSession session;

    public StudentDashboard(BufferedReader consoleReader, ScreenRouter router, UserSession session) {
        super("StudentDashboard", "/sdashboard", consoleReader, router);
        this.session = session;
    }

    @Override
    public void render() throws Exception {
        String menu = "\nWelcome " + session.getCurrentUser().getFirstName() + "!\n"+ //would like to add username to the welcome need to figure out how to read that off the login
                "Please type the number of one of the following options.\n" +
                "1) User Profile\n" +
                "2) Register for new course\n" +
                "3) View Schedule\n" +
                "4) Log out\n" +
                "> ";

        System.out.print(menu);

        String userSelection = consoleReader.readLine();

    }
}

