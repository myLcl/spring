package com.lcl.rabbitmq;

import com.lcl.rabbitmq.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by conglin.liu on 2017/6/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutSenderTest {
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public  void test() {
        fanoutSender.send();
    }
}
