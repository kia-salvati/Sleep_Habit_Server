package com.sleepHabit.HabitSersver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sleepHabit.HabitSersver" )
@EnableAutoConfiguration
public class HabitSersverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitSersverApplication.class, args);
	}


	
}
