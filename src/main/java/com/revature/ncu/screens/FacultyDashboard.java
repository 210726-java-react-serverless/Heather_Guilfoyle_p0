package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyDashboard extends Screens {

    public FacultyDashboard(BufferedReader consoleReader, ScreenRouter router){
        super("FacultyDashboard", "/fdashboard", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

    }

}
