package com.zjb.dao;

import java.util.List;

import com.zjb.entity.Address;
import com.zjb.entity.User;

public interface UserDao extends BaseDao<User, Integer> {
	public List<Address> getAddresses(Integer id);
}
