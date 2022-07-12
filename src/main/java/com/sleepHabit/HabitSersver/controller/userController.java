package com.sleepHabit.HabitSersver.controller;


import java.util.List;

import com.sleepHabit.HabitSersver.model.Role.RoleRepository;
import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.auth.UserDao;
import com.sleepHabit.HabitSersver.model.auth.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private UserDao userDao;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;



    @GetMapping("/user/get-all")
    public List<User>getAllusers() {
        return userDao.getAllusers();
    }

    @PostMapping("/user/auth/register")
    public ResponseEntity<?> register (@Validated @RequestBody User newUser) {
       
        // add check for username exists in a DB
        if(userRepository.existsByUsername(newUser.getUserName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }else if(userRepository.existsByEmail(newUser.getEmail())) {
            // add check for email exists in DB
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        else{
        userDao.save(newUser);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }}

    @PostMapping("/user/auth/login")
    public ResponseEntity<String> authenticateUser(@Validated @RequestBody User checkUser) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            checkUser.getEmail(), checkUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

   @DeleteMapping("/user/delete{userid}")
   public void delete (@RequestBody int userid){
       userDao.deleteById(userid);
   }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails ramesh = User.builder().username("ramesh").password(passwordEncoder()
//                .encode("password")).roles("USER").build();
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder()
//                .encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(ramesh, admin);
//    }



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
