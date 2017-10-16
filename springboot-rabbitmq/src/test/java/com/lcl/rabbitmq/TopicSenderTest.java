package com.lcl.rabbitmq;

import com.lcl.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by conglin.liu on 2017/6/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicSenderTest {

    @Autowired
    private TopicSender sender;

    @Test
    public void topic1() throws Exception {
        sender.send1();
    }

    @Test
    public void topic2() throws Exception {
        sender.send2();
    }
}