package com.zjb.test;


import java.util.Enumeration;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.transaction.Status;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * <b>Summary: </b>
 *      TODO 通过springmvc 测试框架完成对action的模拟集成测试  
 *      关键是完成对OpenSessionInViewFilter过滤器的添加，
 *      保证hibernate session在当前请求过程中保持open状态。
 * <b>Author: </b>
 *      jackybing
 * <b>Date: </b>
 *      2014-3-31 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:WebRoot/WEB-INF/springMVC-servlet.xml","classpath:applicationContext.xml"})
public class UserActionTest{

	@Autowired
	private WebApplicationContext wac;
	

	private MockMvc mockMvc;	

	
	/**
	 * <b>Summary: </b>
	 *     这个方法主要作用是给mockMvc对象添加OpenSessionInViewFilter过滤器，
	 *     保证hibernate session在当前请求过程中保持open状态，否则无法真正地对action
	 *     进行模拟测试操作。
	 *     参考网页：http://forum.spring.io/forum/spring-projects/data/123358-in-unit-testing-transactions-aren-t-committed/page2
	 * @throws ServletException 
	 */
	@Before
	public void setup() throws ServletException {
		javax.servlet.Filter osiv = new org.springframework.orm.hibernate4.support.OpenSessionInViewFilter();
		
		org.springframework.mock.web.MockFilterConfig filterConfig = new org.springframework.mock.web.MockFilterConfig(wac.getServletContext(), "osiv");
		
		osiv.init(filterConfig);

		this.mockMvc = MockMvcBuilders
		            .webAppContextSetup(wac)
		            .addFilter(osiv)
		            .build();
	}
	
	@After
	public void destroy(){
		wac=null;
		mockMvc=null;
	}
	

	@Test
	public void testGetInfo() throws Exception {     
		this.mockMvc.perform(MockMvcRequestBuilders.get("/user/getInfo/4")).andReturn().getAsyncResult();  
				//post("/user/getInfo/4").param("password", "zjb")).andReturn();				
	}

}
