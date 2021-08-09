package com.revature.ncu.util;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class MongoFactory {

    private MongoClient mongoClient;
    private static final MongoFactory mongoFactory = new MongoFactory();

    private MongoFactory() {

        Properties appProperties = new Properties();

        try {
            appProperties.load(new FileReader("src/main/resources/application.properties"));

            String ipAddress = appProperties.getProperty("ipAddress");
            int port = Integer.parseInt(appProperties.getProperty("port"));
            String dbName = appProperties.getProperty("dbName");
            String username = appProperties.getProperty("username");
            char[] password = appProperties.getProperty("password").toCharArray();

            List<ServerAddress> hosts = Collections.singletonList(new ServerAddress(ipAddress, port));
            MongoCredential credentials = MongoCredential.createScramSha1Credential(username, dbName, password);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyToClusterSettings(builder -> builder.hosts(hosts))
                    .credential(credentials)
                    .build();

            this.mongoClient = MongoClients.create(settings);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e){
        e.printStackTrace();
        }

    }

    public void cleanUp(){
        mongoClient.close();
    }

    public static MongoFactory getInstance(){
        return mongoFactory;
    }

    public MongoClient getConnection(){
        return mongoClient;
    }
}
