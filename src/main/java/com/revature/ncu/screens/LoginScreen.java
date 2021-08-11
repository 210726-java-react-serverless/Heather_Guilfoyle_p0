package com.revature.ncu.screens;

import com.revature.ncu.models.User;
import com.revature.ncu.services.UserService;
import com.revature.ncu.util.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public class LoginScreen extends Screens {

    private final UserService userService;
    private final Logger logger = LogManager.getLogger(LoginScreen.class);

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

                if(authUser.getMemberType().equalsIgnoreCase("F")) {
                    logger.info("Successful Faculty Login");
                    router.navigate("/fdashboard");

                }if(authUser.getMemberType().equalsIgnoreCase("S")){
                    logger.info("Successful Student login");
                    router.navigate("/sdashboard");
                }

        } catch (RuntimeException re) {
            System.out.println("No user found");
            logger.debug("No user found");
            router.navigate("/welcome");
        }

    }
}
