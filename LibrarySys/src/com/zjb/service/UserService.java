package com.zjb.service;

import java.util.List;

import com.zjb.entity.Address;
import com.zjb.entity.User;

public interface UserService extends BaseService<User, Integer> {
	public List<Address> getAddresses(Integer id);
}
