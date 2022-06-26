package com.sleepHabit.HabitSersver.model.auth;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

      
    public void deleteById(int userid){
        repository.deleteById(userid);
        
    }

    public Optional<User> findById(int userid){
        return repository.findById(userid);
    }
   
}
