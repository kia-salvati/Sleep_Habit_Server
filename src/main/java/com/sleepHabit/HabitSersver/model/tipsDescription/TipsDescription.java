package com.sleepHabit.HabitSersver.model.tipsDescription;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sleepHabit.HabitSersver.model.tag.Tag;


@Entity
@Table(name = "TipsDescription")
public class TipsDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tdid;

    
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TagsID_TipID", nullable = false)
    private Tag tagID;

    public int getTDid(){
        return tdid;
    }
    public void setTDid(int TDid){
        this.tdid = TDid;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String describe){
        this.description = describe;
    }

    public Tag getTagid(){
        return tagID;
    }
    public void setTagid(Tag tagid){
        this.tagID = tagid;
    }


    @Override
    public String toString(){
        return "TipsDescription{" + "tdid=" + tdid + '\'' + ", describe='" + description + '\'' + '}';
    }
    
}
