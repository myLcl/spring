package com.rabbitmq.direct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by conglin.lin on 2017/6/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectSenderTest {
    @Autowired
    private DirectSender directSender;

    @Test
    public void name() throws Exception {
        directSender.send();
    }
}