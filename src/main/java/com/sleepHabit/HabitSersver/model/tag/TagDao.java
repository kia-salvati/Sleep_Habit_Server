package com.sleepHabit.HabitSersver.model.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class TagDao {

    @Autowired
    private TagRepository repository;

    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    public List<Tag> getAlltgs(){
        List<Tag> tags = new ArrayList<Tag>();
        Streamable.of(repository.findAll()).forEach(tags::add);
        return tags;
    }

    public void deleteById(int tagid){
        repository.deleteById(tagid);
    }

}

