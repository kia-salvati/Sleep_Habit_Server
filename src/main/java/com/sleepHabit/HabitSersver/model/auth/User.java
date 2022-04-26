package com.sleepHabit.HabitSersver.model.auth;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;


    public int getId() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }

    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username='" + username + '\'' +" password='" + password + '\'' + " email='" + email + '\'' + '}'; 
    }


}