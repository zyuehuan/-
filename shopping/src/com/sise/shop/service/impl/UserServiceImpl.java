package com.sise.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sise.shop.dao.UserDao;
import com.sise.shop.po.User;
import com.sise.shop.service.UserService;
import com.sise.shop.vo.Pager;

@Transactional(readOnly=false)
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;
	@Override
	public User getUserById(Integer id) {
		return userDao.findUserById(id);
	}
	


	@Override
	public void addSUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateSUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public List<User> findAllUser(int page,int pageSize) {
		return userDao.getAllUser(page, pageSize);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.getAllUser();
	}
	
	@Override
	public Pager getPagerOfAllUser(int pageSize) {
		int count = userDao.getCountOfAllUser();
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}


	@Override
	public List<User> getUser1(String phone, String password) {
		
		return userDao.findUser1(phone,password);
	}



	public boolean getUserByphone(String phone){
		return userDao.findUserByphone(phone);
	}


}
