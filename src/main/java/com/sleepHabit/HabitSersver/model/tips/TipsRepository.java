package com.sleepHabit.HabitSersver.model.tips;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface TipsRepository extends CrudRepository<Tips, Integer> {
    
}
