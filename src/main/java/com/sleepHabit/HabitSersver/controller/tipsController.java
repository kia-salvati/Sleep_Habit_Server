package com.sleepHabit.HabitSersver.controller;

import java.util.List;

import com.sleepHabit.HabitSersver.model.tips.Tips;
import com.sleepHabit.HabitSersver.model.tips.TipsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tipsController {
    
  @Autowired
  private TipsDao tipsDao;

  @GetMapping("/tip/get-all")
  public List<Tips> getAllTips(){
      return tipsDao.getAllTips();
  }

  @PostMapping("/tip/save")
  public Tips save (@RequestBody Tips tips){
      return tipsDao.save(tips);
  }

  @DeleteMapping("/tip/{tipId}")
  public void delete (@RequestBody int tipid){
      tipsDao.deleletById(tipid);
  }

}
