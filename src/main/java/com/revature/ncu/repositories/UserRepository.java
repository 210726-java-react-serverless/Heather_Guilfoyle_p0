package com.revature.ncu.repositories;


import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.ncu.models.User;
import com.revature.ncu.util.MongoFactory;
import org.bson.Document;



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
    public User save(User newUser) {

        try  {
            MongoClient mongoClient = MongoFactory.getInstance().getConnection();

            MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
            MongoCollection<Document> usersCollection = ncuDb.getCollection("users");
            Document newUserDoc = new Document("firstName", newUser.getFirstName())
                    .append("lastName", newUser.getLastName())
                    .append("email", newUser.getEmail())
                    .append("username", newUser.getUsername())
                    .append("password", newUser.getPassword())
                    .append("memberType", newUser.getMemberType());

            usersCollection.insertOne(newUserDoc);


            return newUser;

        } catch (Exception e) {
            e.printStackTrace();

        }
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
