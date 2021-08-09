package com.revature.ncu.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.ncu.models.Course;
import com.revature.ncu.models.User;
import com.revature.ncu.util.MongoFactory;
import org.bson.Document;

public class CourseRepository implements CrudRepository<Course>{
   public Course findByCourseID(String courseID) {

       try {
           MongoClient mongoClient = MongoFactory.getInstance().getConnection();

           MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
           MongoCollection<Document> usersCollection = ncuDb.getCollection("classes");
           Document queryDoc = new Document("courseID", courseID);
           Document findCourseIDDoc = usersCollection.find(queryDoc).first();

           if (findCourseIDDoc == null) {
               return null;
           }

           ObjectMapper mapper = new ObjectMapper();
           Course foundCourse = mapper.readValue(findCourseIDDoc.toJson(), Course.class);
           return foundCourse;

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
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course newCourse) {

        try  {
            MongoClient mongoClient = MongoFactory.getInstance().getConnection();

            MongoDatabase ncuDb = mongoClient.getDatabase("ncu");
            MongoCollection<Document> usersCollection = ncuDb.getCollection("classes");
            Document newCourseDoc = new Document("courseID", newCourse.getCourseID())
                    .append("courseName", newCourse.getCourseName())
                    .append("courseTeacher", newCourse.getCourseTeacher())
                    .append("courseDescription", newCourse.getCourseDescription())
                    .append("meetDay", newCourse.getMeetDay())
                    .append("meetTime", newCourse.getMeetTime());

            usersCollection.insertOne(newCourseDoc);


            return newCourse;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    @Override
    public boolean update(Course newCourse) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
