package com.sise.shop.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.shop.dao.UserDao;
import com.sise.shop.po.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Override
	public User findUserById(Integer id) {
		User user = getHibernateTemplate().get(User.class, id);	
		return user;
	}
	

	
	@Override
	public void addUser(User user) {
		getHibernateTemplate().persist(user);
		
	}
	
	@Override
	public void updateUser(User user) {
		getHibernateTemplate().saveOrUpdate(user);
		
	}
	/*
	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = getHibernateTemplate().get(User.class, id);
		getHibernateTemplate().delete(user);
		
	}
	*/
	@Override
	public List<User> getAllUser(final int page,final int pageSize) {
		List<User> users = null;
		try {
			users = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from User");
			query.setFirstResult(pageSize*(page-1));
			query.setMaxResults(pageSize);
			List userss = query.list();
			return userss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return users;
	}
	
	@Override
	public List<User> getAllUser() {
		List<User> users = (List<User>) getHibernateTemplate().find("from User");
		return users;
	}

	@Override
	public int getCountOfAllUser() {
		List<User> users = (List<User>) getHibernateTemplate().find("from User");
		return users.size();
	}
	 @SuppressWarnings("unchecked")
	
	

	@Override
	public boolean findUserByphone(String phone) {
		List<User> users = (List<User>) getHibernateTemplate().find("from User where phone=?",phone);
		if(users.size()>0)	
			return true;
		else
			return false;
	}

	@Override
	public List<User> findUser1(String phone, String password) {
		List userlist= getHibernateTemplate().find("from User where phone=? and password=?",phone,password);
		return userlist;
	}

	

	
 
}
