package com.springData.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by conglin.liu on 2017/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyPropertyTest {
    @Autowired
    private MyProperty myProperty;

    @Test
    public void test() {
        System.out.println(myProperty.getName());
    }
}