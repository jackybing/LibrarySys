package com.zjb.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjb.dao.BaseDao;
import com.zjb.dao.UserDao;
import com.zjb.service.BaseService;

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK>  {

	@Autowired
	private BaseDao<T, PK> baseDao;
	
	public void delete(T entity) {
		baseDao.delete(entity);
			}

	public void delete(PK id) {
		baseDao.delete(id);
			}

	public void delete(PK[] ids) {
		baseDao.delete(ids);
			}

	public T get(PK id) {
		return baseDao.get(id);
	}

	public List<T> getAllList() {
		return baseDao.getAllList();
	}

	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	public T load(PK id) {
		return baseDao.load(id);
	}

	public PK save(T entity) {
		return baseDao.save(entity);
	}

	public void update(T entity) {
		baseDao.update(entity);
	}
}
