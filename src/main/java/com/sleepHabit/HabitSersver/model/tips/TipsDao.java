package com.sleepHabit.HabitSersver.model.tips;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class TipsDao {
    
    @Autowired
    private TipsRepository repository;

    public Tips save(Tips tips){
        return repository.save(tips);
    }

    public List<Tips> getAllTips(){
        List<Tips> tips = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(tips::add);
        return tips;
    }

    public void deleletById(int tipid){
        repository.deleteById(tipid);
    }
}
