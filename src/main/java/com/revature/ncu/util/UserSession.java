package com.revature.ncu.util;

import com.revature.ncu.models.User;

public class UserSession {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
