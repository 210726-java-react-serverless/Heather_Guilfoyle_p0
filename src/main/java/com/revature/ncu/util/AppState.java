package com.revature.ncu.util;

import com.revature.ncu.screens.LoginScreen;
import com.revature.ncu.screens.RegisterScreen;
import com.revature.ncu.screens.WelcomeScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router.addScreen(new WelcomeScreen(consoleReader, router));
        router.addScreen(new RegisterScreen(consoleReader,router));
        router.addScreen(new LoginScreen(consoleReader,router));
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
}
