package com.zjb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjb.dao.UserDao;
import com.zjb.entity.Address;
import com.zjb.entity.User;

@Repository(value="userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	public List<Address> getAddresses(Integer id) {
		return this.get(id).getAddresses();
	}
}
