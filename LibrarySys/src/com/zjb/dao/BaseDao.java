package com.zjb.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,PK extends Serializable> {
	
	/**
	 * ����ID��ȡʵ�����
	 * 
	 * @param id
	 *            ��¼ID
	 * @return ʵ�����
	 */
	public T get(PK id);

	/**
	 * ����ID��ȡʵ�����
	 * 
	 * @param id
	 *            ��¼ID
	 * @return ʵ�����
	 */
	public T load(PK id);

	/**
	 * ��ȡ����ʵ����󼯺�
	 * 
	 * @return ʵ����󼯺�
	 */
	public List<T> getAllList();
	
	/**
	 * ��ȡ����ʵ���������
	 * 
	 * @return ʵ���������
	 */
	public Long getTotalCount();

	/**
	 * ����ʵ�����
	 * 
	 * @param entity
	 *            ����
	 * @return ID
	 */
	public PK save(T entity);

	/**
	 * ����ʵ�����
	 * 
	 * @param entity
	 *            ����
	 */
	public void update(T entity);
	
	/**
	 * ɾ��ʵ�����
	 * 
	 * @param entity
	 *            ����
	 * @return
	 */
	public void delete(T entity);

	/**
	 * ����IDɾ��ʵ�����
	 * 
	 * @param id
	 *            ��¼ID
	 */
	public void delete(PK id);

	/**
	 * ����ID����ɾ��ʵ�����
	 * 
	 * @param ids
	 *            ID����
	 */
	public void delete(PK[] ids);
	
}
