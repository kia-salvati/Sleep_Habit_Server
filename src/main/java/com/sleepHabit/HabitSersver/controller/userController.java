package com.sleepHabit.HabitSersver.controller;


import java.util.List;
import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.auth.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user/get-all")
    public List<User>getAllusers() {
        return userDao.getAllusers();
    }

    @PostMapping("/user/save")
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("/user/delete")
        public void delete (@RequestBody int userid) {
            userDao.delete(userid);
        }
    

    
}
