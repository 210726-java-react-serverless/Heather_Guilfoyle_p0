package com.revature.ncu.repositories;

import com.revature.ncu.models.UserSchedule;

public class UserCoursesRepository implements CrudRepository<UserSchedule>{

    @Override
    public UserSchedule findById(int id) {
        return null;
    }

    @Override
    public UserSchedule save(UserSchedule newResource) {
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
