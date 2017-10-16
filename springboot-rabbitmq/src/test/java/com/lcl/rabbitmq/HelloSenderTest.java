package com.lcl.rabbitmq;

import com.lcl.rabbitmq.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by conglin.liu on 2017/10/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSenderTest {
    
  @Autowired  
  private HelloSender helloSender;

    @Test
    public void name() throws Exception {
      for (int i = 0; i < 100; i++) {
        helloSender.send();
      }
    }
}
