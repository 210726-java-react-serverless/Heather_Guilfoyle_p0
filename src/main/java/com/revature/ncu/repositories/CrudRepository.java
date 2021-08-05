package com.revature.ncu.repositories;

public interface CrudRepository<T> {

    T findById(int id); // Read
    T save(T newResource); //Create
    boolean update(T updatedResource); //Update
    boolean deleteById(int id); //Delete
}
