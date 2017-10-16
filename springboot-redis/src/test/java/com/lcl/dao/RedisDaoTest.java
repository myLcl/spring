package com.lcl.dao;

import com.lcl.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by conglin.liu on 2017/10/16.
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