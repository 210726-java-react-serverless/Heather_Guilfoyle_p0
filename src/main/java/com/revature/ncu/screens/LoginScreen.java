package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screens {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router){
        super("LoginScreen", "/login", consoleReader, router);

    }

    @Override
    public void render() throws Exception {

        System.out.println("\nNCU Login Center\n");

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        //TODO If username and password is correct navigate to correct dashboard otherwise have them try again.
    }
}
