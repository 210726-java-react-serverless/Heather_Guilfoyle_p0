package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;
import java.io.BufferedReader;

public class WelcomeScreen extends Screens {

   public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router){
       super("WelcomeScreen", "/welcome", consoleReader, router);
       System.out.println("WelcomeScreen instantiated!");
   }


    @Override
    public void render() throws Exception {

    }
}
