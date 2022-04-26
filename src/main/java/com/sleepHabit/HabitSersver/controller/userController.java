package com.sleepHabit.HabitSersver.controller;


import java.util.List;
import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.auth.UserDao;
import com.sleepHabit.HabitSersver.model.auth.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private UserDao userDao;

    private UserRepository userRepository;

    @GetMapping("/user/get-all")
    public List<User>getAllusers() {
        return userDao.getAllusers();
    }

    @PostMapping("/user/save")
    public User save(@Validated @RequestBody User user) {
        return userDao.save(user);
    }

   @DeleteMapping("/user/delete{userid}")
   public void delete (@RequestBody int userid){
       userDao.deleteById(userid);
   }

   @PutMapping("/user/{userid}/")
   public User update(@Validated @RequestBody User userRequest){
        User user;
        return userDao.findById(userid).map(post->{  
            user.setUserName(userRequest.getUserName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            return userDao.save(user);
        }).orElseThrow(()->new ResourceNotFoundException("userid" + userid + " not found"));
   }

}
