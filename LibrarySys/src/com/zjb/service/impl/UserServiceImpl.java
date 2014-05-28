package com.zjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjb.dao.UserDao;
import com.zjb.entity.Address;
import com.zjb.entity.User;
import com.zjb.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements
		UserService {
	
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	
	public List<Address> getAddresses(Integer id){
		return userDao.getAddresses(id);
	}
}
