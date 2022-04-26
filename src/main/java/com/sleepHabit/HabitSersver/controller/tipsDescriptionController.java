package com.sleepHabit.HabitSersver.controller;

import java.util.List;

import com.sleepHabit.HabitSersver.model.tipsDescription.TipsDescription;
import com.sleepHabit.HabitSersver.model.tipsDescription.TipsDescriptionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tipsDescriptionController {
    
    @Autowired
    private TipsDescriptionDao TDDao;

    @GetMapping("/td/get-all")
    public List<TipsDescription> getAllTags(){
        return TDDao.getAllTD();
    }
  
    @PostMapping("/td/save")
    public TipsDescription save (@RequestBody TipsDescription td){
        return TDDao.save(td);
    }
  
    @DeleteMapping("/td/{tdid}")
    public void delete (@RequestBody int tdid){
        TDDao.deleteById(tdid);
    }
}

