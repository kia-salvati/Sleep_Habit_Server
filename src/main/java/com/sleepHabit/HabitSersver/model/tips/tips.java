package com.sleepHabit.HabitSersver.model.tips;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipID;
    private String tip;
    
}
