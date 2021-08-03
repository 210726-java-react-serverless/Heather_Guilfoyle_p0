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
    }
}
