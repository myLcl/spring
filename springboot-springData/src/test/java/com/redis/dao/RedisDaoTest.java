package com.redis.dao;

import com.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by conglin.liu on 2017/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisDaoTest {
    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis(){
        redisDao.setKey("name","forezp");
        System.out.println(redisDao.getValue("name"));
    }
}