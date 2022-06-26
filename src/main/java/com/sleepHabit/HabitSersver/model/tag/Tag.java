package com.sleepHabit.HabitSersver.model.tag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagid;

    private String tag;

  
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
