package com.zjb.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

import com.zjb.entity.User;
import com.zjb.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/applicationContext.xml") 
@Transactional
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Ignore
	@Test
	public void testSave(){
		User user =new User();
		user.setUsername("jackybing");
		user.setPassword("zjb");
		Integer idInteger=userService.save(user);
		System.out.println(idInteger);
		Assert.assertNotNull(idInteger);
	}
	
	
	@Test
	public void testLoad(){
		Assert.assertNotNull(userService.load(1).getAddresses());		
	}
}
