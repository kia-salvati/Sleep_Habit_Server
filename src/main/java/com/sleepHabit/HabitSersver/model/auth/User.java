package com.sleepHabit.HabitSersver.model.auth;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import javax.persistence.*;

import com.sleepHabit.HabitSersver.model.Role.Role;
import com.sleepHabit.HabitSersver.model.tag.Tag;

@Entity
@Table(name = "users", uniqueConstraints = { 
    @UniqueConstraint(columnNames = { "username"}),
    @UniqueConstraint(columnNames = { "email"}) 
})
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;

    // relationship between user and tag
    @ManyToMany(fetch =FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_tag", joinColumns ={ @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "tagid") })
    private Set<Tag> tags = new HashSet<>();


    
    // relationship between  user and role
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Override
    public String toString() {
        return "Users{" + "id=" + id + '\'' + ", username='" + username + '\'' +" password='" + password + '\'' + " email='" + email + '\'' + '}'; 
    }
   
}