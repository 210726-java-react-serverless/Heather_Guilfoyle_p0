package com.revature.ncu.repositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.ncu.models.User;
import org.bson.Document;

import java.util.Arrays;

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

        try (MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("3.136.233.217", 27017))))
                        .credential(MongoCredential.createScramSha1Credential("project0","ncu","revature".toCharArray()))
                        .build()
        )) {

            MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
            MongoCollection<Document> usersCollection = ncuDb.getCollection("users");
            Document newUserDoc = new Document("firstName", newUser.getFirstName())
                    .append("lastName", newUser.getLastName())
                    .append("email", newUser.getEmail())
                    .append("username", newUser.getUsername())
                    .append("password", newUser.getPassword());

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
