package com.springData.repository;

import com.springData.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTests.class);
	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		logger.debug("debug==============================");
		logger.error("error==============================");
		logger.info("info==================================");
		logger.warn("warn====================================");
		List<User> userList = userRepository.findAll();
		for (int i = 0; i < userList.size() ; i++) {
			System.out.println(userList.get(i));
		}
	}

}