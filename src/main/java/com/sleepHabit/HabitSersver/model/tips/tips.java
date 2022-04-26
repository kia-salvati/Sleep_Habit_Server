package com.sleepHabit.HabitSersver.model.tips;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.sleepHabit.HabitSersver.model.tag.Tag;

@Entity
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipid;
    private String tip;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="tips_tag", joinColumns = {@JoinColumn(name = "tip_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    public int getTipId(){
        return tipid;
    }
    public void setTipId(int tipId){
        this.tipid = tipId;
    }

    public String getTip() {
        return tip;
    }
    public void setTip(String Tip){
        this.tip=Tip;
    }

    @Override
    public String toString() {
        return "Tips{" + "tipid='" + tipid + '\'' + " tip='" + tip + '\'' + '}';
    }
}
