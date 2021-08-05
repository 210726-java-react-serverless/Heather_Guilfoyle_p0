package com.revature.ncu.repositories;

import com.revature.ncu.models.User;

/*
These fields will have language that connects to Mongo to fulfill these operations
 */
public class UserRepository implements CrudRepository<User> {
/**
 * Used to find a username name in the database for login
 * @param password
 * @param username
 * */

    public User findByCredentials(String username, String password) {
        return null;
    }
    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User newResource) {
        return null;
    }

    @Override
    public boolean update(User updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
