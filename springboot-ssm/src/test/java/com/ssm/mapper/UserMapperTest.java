package com.ssm.mapper;

import java.util.List;

import com.ssm.entity.UserEntity;
import com.ssm.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));

	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = userMapper.getAll();
		for (int i = 0; i <users.size() ; i++) {
			System.out.println(users.get(i));
		}
	}

}