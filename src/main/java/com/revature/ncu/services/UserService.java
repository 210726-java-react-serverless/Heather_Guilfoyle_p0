package com.revature.ncu.services;

import com.revature.ncu.models.User;
import com.revature.ncu.repositories.UserRepository;
import com.revature.ncu.util.UserSession;

public class UserService {

    private final UserRepository userRepo;
    private final UserSession session;

    public UserService(UserRepository userRepo, UserSession session) {
        this.userRepo = userRepo;
        this.session = session;
    }

    /**
     * This will validate user input to make sure that it is acceptable and if validated save the user
     * @param newUser
     * */

    public User register(User newUser) {
        return userRepo.save(newUser);
    }

    /**
     * This will be used to validate that the username and password match a saved User
     * and navigate them to the proper dashboard.
     * @param password
     * @param username
     * */
    public User login(String username, String password) {

        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
         throw new RuntimeException("Invalid user credentials");
        }

        User authUser = userRepo.findByCredentials(username, password);

        if (authUser == null) {
          throw new RuntimeException("Invalid credentials provided!");
        }

        session.setCurrentUser(authUser);
        return authUser;
    }

    /**
     * This is to make sure that the user is filling in all of the fields
     * */

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return user.getMemberType() != null && !user.getMemberType().trim().equals("");
    }


}




