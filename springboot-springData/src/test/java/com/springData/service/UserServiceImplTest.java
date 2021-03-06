package com.springData.service;

import com.springData.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by QuantGroup on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void findOne() throws Exception {
        User user = new User("李四");
        userService.save(user);
        System.out.println(userService.findOne(user.getId()));
        System.out.println(userService.findOne(user.getId()));
    }

    @Test
    public void delete() {
        userService.delete(Long.valueOf(1));
        System.out.println(userService.findOne(Long.valueOf(1)));
    }


}