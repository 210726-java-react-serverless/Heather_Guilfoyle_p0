package com.revature.ncu.screens;

import com.revature.ncu.models.User;
import com.revature.ncu.services.UserService;
import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screens {

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService){
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;

    }

    @Override
    public void render() throws Exception {

        System.out.println("\nNCU Login Center\n");

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        try {
            User authUser = userService.login(username, password);

                if(authUser.getMemberType().equalsIgnoreCase("f")) {
                    router.navigate("/fdashboard");
                }if(authUser.getMemberType().equalsIgnoreCase("s")){
                    router.navigate("/sdashboard");
                }

        } catch (RuntimeException re) {
            System.out.println("No user found");
        }

        //TODO If username and password is correct navigate to correct dashboard otherwise have them try again.
    }
}
