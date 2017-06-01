package com.springData.service;

import com.springData.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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
        System.out.println(userService.findOne(Long.valueOf(1)));
        System.out.println(userService.findOne(Long.valueOf(1)));
    }

    @Test
    public void delete() {
        userService.delete(Long.valueOf(1));
        System.out.println(userService.findOne(Long.valueOf(1)));
    }


    @Test
    public void save() {
        User user = new User("李四");
        userService.save(user);
        System.out.println(userService.findOne(user.getId()));
    }



}