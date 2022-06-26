package com.sleepHabit.HabitSersver.model.tips;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipid;
    private String tip;

    
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
