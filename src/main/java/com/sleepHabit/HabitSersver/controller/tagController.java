package com.sleepHabit.HabitSersver.controller;

import java.util.List;

import com.sleepHabit.HabitSersver.model.tag.Tag;
import com.sleepHabit.HabitSersver.model.tag.TagDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tagController {
    
    @Autowired
    private TagDao tagDao;

    @GetMapping("/tag/get-all")
    public List<Tag> getAllTags(){
        return tagDao.getAlltgs();
    }
  
    @PostMapping("/tag/save")
    public Tag save (@RequestBody Tag tags){
        return tagDao.save(tags);
    }
  
    @DeleteMapping("/tag/{tagId}")
    public void delete (@RequestBody int tagid){
        tagDao.deleteById(tagid);
    }
}
