package com.sise.shop.service;

import java.util.List;

import com.sise.shop.po.User;
import com.sise.shop.vo.Pager;

public interface UserService {
	public User getUserById(Integer id);
	public boolean getUserByphone(String phone);
	public List<User> getUser1(String phone,String password);
	public void addSUser(User user);
	public void updateSUser(User user);
	//public void deleteSUser(Integer id);
	public List<User> findAllUser(int page,int pageSize);
	public List<User> findAllUser();

	public Pager getPagerOfAllUser(int pageSize);

}
