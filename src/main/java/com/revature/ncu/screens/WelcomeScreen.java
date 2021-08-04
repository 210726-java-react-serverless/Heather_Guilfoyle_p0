package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;
import java.io.BufferedReader;

public class WelcomeScreen extends Screens {

   public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router){
       super("WelcomeScreen", "/welcome", consoleReader, router);

   }


    @Override
    public void render() throws Exception {

       String menu = "\nWelcome to New Coder University\n" +
               "Please type the number of one of the following options.\n" +
               "1) Login\n" +
               "2) Register\n" +
               "3) Exit application\n" +
               "> ";

       System.out.print(menu);

       String userSelection = consoleReader.readLine(); //without this line the screen renders as a broken loop

        switch (userSelection) {

            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Now Exiting");
                System.exit(0); //TODO Needs to be fixed. This is apparently ugly.
                break;
            default:
                System.out.println("Please pick a number between 1 - 3");

        }

    }
}
