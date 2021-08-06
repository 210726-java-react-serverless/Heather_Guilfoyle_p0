package com.revature.ncu.screens;

import com.revature.ncu.models.User;
import com.revature.ncu.services.UserService;
import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;


public class RegisterScreen extends Screens {

    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register", consoleReader, router);
        this.userService = userService;

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

        User newUser = new User(firstName, lastName, email, username, password, memberType);
        System.out.println(newUser);

        //TODO Validate Registration is successful. If true System.out.println "Success." and navigate to dashboard.
        userService.register(newUser);
        System.out.println("Success");
        router.navigate("/welcome");
    }
}
