package com.sleepHabit.HabitSersver.model.tag;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.tips.Tips;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagid;

    private String tag;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tags")
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tags")
    private Set<Tips> tips = new HashSet<>();

    
    public int getTagid() {
        return tagid;
    }
    public void setTagid(int tagid){
        this.tagid = tagid;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag){
        this.tag = tag;
    }

    @Override
    public String toString(){
        return "Tag [tagid=" + tagid + ", tag=" + tag + "]";
    }

}
