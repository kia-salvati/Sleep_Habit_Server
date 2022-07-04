package com.sleepHabit.HabitSersver.model.auth;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User findByUsernameOrEmail(String username, String Email );

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}