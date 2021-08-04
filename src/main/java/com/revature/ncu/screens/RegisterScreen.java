package com.revature.ncu.screens;

import com.revature.ncu.models.AppUser;
import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;
import java.sql.SQLOutput;

public class RegisterScreen extends Screens {

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("RegisterScreen", "/register", consoleReader, router);

    }
    @Override
    public void render() throws Exception {
        System.out.println("\nRegister for a new account!");

        System.out.print("First name: ");
        String firstName = consoleReader.readLine();

        System.out.print("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.print("Email: ");
        String email = consoleReader.readLine();

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.print("Type \"S\" for student or \"F\" for faculty: ");
        String memberType = consoleReader.readLine();

        AppUser newUser = new AppUser(firstName, lastName, email, username, password, memberType);
        System.out.println(newUser);

        //TODO Validate Registration is successful. If true System.out.println "Success." and navigate to dashboard.
        System.out.println("Success");
        router.navigate("/welcome");
    }
}
