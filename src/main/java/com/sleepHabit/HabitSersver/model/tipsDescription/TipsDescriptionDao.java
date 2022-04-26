package com.sleepHabit.HabitSersver.model.tipsDescription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class TipsDescriptionDao {

    @Autowired
    private TipsDescriptionRepository repository;

    public TipsDescription save(TipsDescription td){
        return repository.save(td);
    }

    public List<TipsDescription> getAllTD(){
        List<TipsDescription> TD = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(TD::add);
        return TD;
    }

    public void deleteById(int tdid){
        repository.deleteById(tdid);
    }
    
}
