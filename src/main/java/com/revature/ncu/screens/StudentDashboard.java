package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentDashboard extends Screens {

    public StudentDashboard(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentDashboard", "/sdashboard", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

    }
}

