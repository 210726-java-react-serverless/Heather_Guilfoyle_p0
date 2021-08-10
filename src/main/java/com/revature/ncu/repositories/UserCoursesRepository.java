package com.revature.ncu.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.ncu.models.UserSchedule;
import com.revature.ncu.util.MongoFactory;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserCoursesRepository implements CrudRepository<UserSchedule>{

    @Override
    public UserSchedule findById(int id) {
        return null;
    }

    @Override
    public UserSchedule save(UserSchedule newSchedule) {
        try  {
            MongoClient mongoClient = MongoFactory.getInstance().getConnection();

            MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
            MongoCollection<Document> usersCollection = ncuDb.getCollection("schedule");
            Document newScheduleDoc = new Document("username",newSchedule.getUsername())
                    .append("courseID", newSchedule.getCourseID())
                    .append("courseName", newSchedule.getCourseName())
                    .append("meetDay", newSchedule.getMeetDay())
                    .append("meetTime", newSchedule.getMeetTime());

            usersCollection.insertOne(newScheduleDoc);


            return newSchedule;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    public List<UserSchedule> findSchedule(String userName){

        List<UserSchedule> allScheduleList = new ArrayList<>();
        try {
            MongoClient mongoClient = MongoFactory.getInstance().getConnection();
            MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
            MongoCollection<Document> usersCollection = ncuDb.getCollection("schedule");
            Document username = new Document("username", userName);
            List<Document> scheduleList = usersCollection.find(username).into(new ArrayList<>());

            ObjectMapper mapper = new ObjectMapper();

            for(Document schedule : scheduleList){
                UserSchedule schedules = mapper.readValue(schedule.toJson(), UserSchedule.class);
                allScheduleList.add(schedules);
            }
            return allScheduleList;

        } catch (
                JsonMappingException e) {
            e.printStackTrace();
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean update(UserSchedule updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
