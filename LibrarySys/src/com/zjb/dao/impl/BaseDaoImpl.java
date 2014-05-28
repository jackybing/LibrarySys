package com.zjb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.zjb.dao.BaseDao;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	private Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(T entity) {
		Assert.notNull(entity, "entiy is required");
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(PK id) {
		Assert.notNull(id, "id is required");
		T entity = (T) getSession().load(entityClass, id);
		getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public void delete(PK[] ids) {
		Assert.notEmpty(ids, "ids must not be empty");
		for (PK id : ids) {
			T entity = (T) getSession().load(entityClass, id);
			getSession().delete(entity);
		}

	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id,"id is required");
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllList() {
		String hql="from " + entityClass.getName();
		return getSession().createQuery(hql).list();
	}

	public Long getTotalCount() {
		String hql = "select count(*) from " + entityClass.getName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}
		

	@SuppressWarnings("unchecked")
	public T load(PK id) {
		Assert.notNull(id,"id is required");
		return (T) getSession().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		Assert.notNull(entity,"entity is required");
		return (PK) getSession().save(entity);
	}

	public void update(T entity) {
		Assert.notNull(entity,"entity is required");
		getSession().update(entity);
	}

}
