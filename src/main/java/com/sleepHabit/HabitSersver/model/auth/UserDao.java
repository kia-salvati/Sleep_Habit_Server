package com.sleepHabit.HabitSersver.model.auth;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;


@Service
public class UserDao {
    
    @Autowired
    private UserRepository repository;

    public User save(User user){
        return repository.save(user);
    }

    public List<User> getAllusers() {
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll())
            .forEach(users::add);
        return users;
      }

    public void delete(int userid){
        repository.deleteById(userid);
    }
}
