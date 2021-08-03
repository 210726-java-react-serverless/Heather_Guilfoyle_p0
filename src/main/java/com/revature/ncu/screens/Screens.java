package com.revature.ncu.screens;

import com.revature.ncu.util.ScreenRouter;

import java.io.BufferedReader;

public abstract class Screens {

    protected String name;
    protected String route;
    protected BufferedReader consoleReader;
    protected ScreenRouter router;


    public Screens(String name, String route, BufferedReader consoleReader, ScreenRouter router ){
        this.name = name;
        this.route = route;
        this.consoleReader = consoleReader;
        this.router = router;
    }

    public String getName() {
        return name;
    }
    public String getRoute() {
        return route;
    }
    /**
     * Render method will be what is used by each screen to display information for
     * the users to interact with.
     * */

    public abstract void render() throws Exception;
}




