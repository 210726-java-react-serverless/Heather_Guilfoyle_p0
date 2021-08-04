package com.revature.ncu.util;

import com.revature.ncu.screens.Screens;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screens currentScreen;
    private Set<Screens> screens = new HashSet<>();

    public ScreenRouter addScreen(Screens screen) {
        screens.add(screen);
        return this;
    }
    /**
     * @param route
     * Navigate changes the current screen to the route specified.
     * */
    public void navigate(String route) {
        for (Screens screen : screens) {
            if (screen.getRoute().equals(route)) {
                currentScreen = screen;
                break;
            }
        }
    }

    public Screens getCurrentScreen() {
        return currentScreen;
    }

}
