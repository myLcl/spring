package com.ssm.lcl.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Control单元测试, 集成web环境, 不需要部署项目
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//加载静态资源,默然加载路径: src/main/webapp
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-control.xml"})
public class BookControllerUnitTest {
	//代表web容器环境
	@Autowired
	WebApplicationContext wac;
	
	//代表mvc的测试环境
	MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	//直接运行
	@Test
	public void getArticleListTest() throws Exception{
		//准备参数: 
		String postJson = "{\"mac\":\"h\",\"dtClient\":\"2015-06-03 13:20:10\"}";

		//发送请求
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/book/list")//contorller路径
											 .accept(MediaType.APPLICATION_JSON)//参数类型
											 .param("criJson",postJson));//参数
		
		//获得响应结果
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
	}

}
