package com.sleepHabit.HabitSersver;

import com.sleepHabit.HabitSersver.model.auth.User;
import com.sleepHabit.HabitSersver.model.auth.UserDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HabitSersverApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void addUserTest() {
		User user = new User();
		user.setUserName("ghareb2");
		user.setEmail("Shit2@gmail.com");
		user.setPassword("1515485");
		userDao.save(user);

	}



}
