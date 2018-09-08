package com.sise.shop.dao;

import java.util.List;

import com.sise.shop.po.User;


public interface UserDao {
	public User findUserById(Integer id);  //根据id查找用户
	public boolean findUserByphone(String phone);  //根据用户名查找用户
	public List<User> findUser1(String phone,String password);//登录查询用户
	public void addUser(User user);		//添加用户
	public void updateUser(User user); 	//修改用户信息
	//public void deleteUserById(Integer id);
	
	public List<User> getAllUser(int page,int pageSize);   //获取指定页数的指定数目的用户
	public List<User> getAllUser();
	public int getCountOfAllUser();  //返回用户列表长度
	
}
