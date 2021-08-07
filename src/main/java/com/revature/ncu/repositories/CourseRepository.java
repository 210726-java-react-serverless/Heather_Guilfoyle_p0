package com.revature.ncu.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.ncu.models.Course;
import com.revature.ncu.util.MongoFactory;
import org.bson.Document;

public class CourseRepository implements CrudRepository<Course>{
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
            Document newCourseDoc = new Document("CourseID", newCourse.getCourseID())
                    .append("CourseName", newCourse.getCourseName())
                    .append("CourseTeacher", newCourse.getCourseTeacher())
                    .append("CourseDescription", newCourse.getCourseDescription())
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
