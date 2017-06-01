package com.ssm.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by conglin.liu on 2017/5/31.
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }

    @Test
    public void getUsers() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/getUsers"));

        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(mvcResult.getResponse().getContentLength());
    }

}