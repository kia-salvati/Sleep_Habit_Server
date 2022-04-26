package com.sleepHabit.HabitSersver.model.tipsDescription;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsDescriptionRepository extends CrudRepository<TipsDescription, Integer>{
    
}