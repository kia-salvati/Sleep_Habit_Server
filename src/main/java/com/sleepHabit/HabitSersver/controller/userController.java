package com.sleepHabit.HabitSersver.controller;


import java.util.List;

import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.auth.UserDao;

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

    @GetMapping("/user/get-all")
    public List<User>getAllusers() {
        return userDao.getAllusers();
    }

    @PostMapping("/user/register")
    public User register (@Validated @RequestBody User newUser) {
        List<User> users = userDao.getAllusers();
        for(User user:users){
            if(newUser.equals(user)){
                System.out.println("User Already exists!");
             }
        }
        return userDao.save(newUser);
    }

    @GetMapping("/user/login")
    public boolean check(@Validated @RequestBody User checkUser) {
        List<User> users = userDao.getAllusers();
        for(User user:users){
            if(checkUser.equals(user))
            return true;
        }return false;
    }

   @DeleteMapping("/user/delete{userid}")
   public void delete (@RequestBody int userid){
       userDao.deleteById(userid);
   }

//    @PutMapping("/user/{userid}/")
//    public User update(@Validated @RequestBody User userRequest, @RequestBody int userid){
//         User user;
//         return userDao.findById(userid).map(post->{  
//             user.setUserName(userRequest.getUserName());
//             user.setEmail(userRequest.getEmail());
//             user.setPassword(userRequest.getPassword());
//             return userDao.save(user);
//         }).orElseThrow(()->new ResourceNotFoundException("userid" + userid + " not found"));
//    }

}
