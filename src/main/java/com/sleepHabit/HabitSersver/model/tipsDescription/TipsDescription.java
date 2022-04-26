package com.sleepHabit.HabitSersver.model.tipsDescription;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sleepHabit.HabitSersver.model.tips.Tips;


@Entity
@Table(name = "TipsDescription")
public class TipsDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tdid;

    
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Tips_tipid", nullable = false)
    private Tips tipid;

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

    public Tips getTipid(){
        return tipid;
    }
    public void setTipid(Tips tipid){
        this.tipid = tipid;
    }


    @Override
    public String toString(){
        return "TipsDescription{" + "tdid=" + tdid + '\'' + ", describe='" + description + '\'' + '}';
    }
    
}
