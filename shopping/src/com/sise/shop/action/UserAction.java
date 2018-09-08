package com.sise.shop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.shop.po.User;
import com.sise.shop.service.UserService;
import com.sise.shop.service.impl.UserServiceImpl;
import com.sise.shop.vo.DBSupportException;
import com.sise.shop.vo.Pager;




@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	@Resource private UserService userService;
	private int uid;
	
	private String oldpassword;

	private String password2;
	private String msg;
	private String username;
	private User user = new User();
	private List<User> users =new ArrayList<User>();
	private Pager pager;
	ServletRequest request = ServletActionContext.getRequest();
	HttpSession session = getRequest().getSession(true);
	private String password1;
	private String address2;

	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public Object getModel() {
		return user;
	}
	public UserAction() {
		
		userService = new UserServiceImpl();
	}
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
		
	}
	protected HttpSession getSession() {
		return getRequest().getSession(false);
	}
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	//登录
	@SuppressWarnings("unchecked")
	public String login() throws DBSupportException,
			IOException {
		request.setCharacterEncoding("utf-8");
		ActionContext ctx = ActionContext.getContext();
		Map session1 = ctx.getSession();
		if((String) session.getAttribute("username")==null||(String) session.getAttribute("username")==""){
		
			username = request.getParameter("username");
			password2 = request.getParameter("password");
			
		
				List<User> userList = null;
	
				userList = userService.getUser1(user.getPhone(),user.getPassword());
				if (userList.size() > 0) {
					String userName = userList.get(0).getUsername();
					
					
					getSession().setAttribute("username", userName);
					user = userList.get(0);
					session1.put("user",user);
					return SUCCESS;
				} else if(user.getPhone()!=""&&user.getPhone().equals("admin")
						&&user.getPassword()!=""&&user.getPassword().equals("admin")){
					getSession().setAttribute("username","admin");
					return "admin";
				}else if(user.getPhone()==""){
					getResponse().setContentType("text/html; charset=GBK");
					PrintWriter out = getResponse().getWriter();
					out.print("<script language=javascript>alert('请输入账号密码');window.location.href='login.jsp';</script>");
					out.close();
					return LOGIN;
				}else if(user.getPassword()==""){
					getResponse().setContentType("text/html; charset=GBK");
					PrintWriter out = getResponse().getWriter();
					out.print("<script language=javascript>alert('请输入密码');window.location.href='login.jsp';</script>");
					out.close();
					return LOGIN;
				}else{
					getResponse().setContentType("text/html; charset=GBK");
					PrintWriter out = getResponse().getWriter();
					out.print("<script language=javascript>alert('账号或密码有误');window.location.href='login.jsp';</script>");
					out.close();
				}
			
		}else {
			return SUCCESS;

		}
		return "login";
	}
	
	//注销
	public String removeSession() throws IOException {
		String username = (String) getSession().getAttribute("username");
		if (username != null && username!="admin") {
			getSession().invalidate();
			return SUCCESS;
		} else if(username.equals("admin")){
			getSession().removeAttribute("username");
			return SUCCESS;
		}
		else {
			System.out.println("error");
			return "error";
		}
	}
	//跳转首页
	public String main(){
		return SUCCESS;
		
	}
	//跳转注册
	public String register(){
			return SUCCESS;
			
		}
		//跳转登录
	public String loginInput(){
			return SUCCESS;
			
		}

	//跳转到注册页面的action
	public String adUser() throws Exception{
		return "add";
	}
	//添加/注册用户
	public String addUser() throws Exception{
			boolean b = userService.getUserByphone(user.getPhone());
			if(b){
				getResponse().setContentType("text/html; charset=GBK");
				PrintWriter out = getResponse().getWriter();
				out.print("<script language=javascript>alert('该手机已注册，请重写');window.location.href='register.jsp';</script>");
				out.close();
				return "add1";
			}
			else if(user.getPhone()==""){
				getResponse().setContentType("text/html; charset=GBK");
				PrintWriter out = getResponse().getWriter();
				out.print("<script language=javascript>alert('请输入手机号');window.location.href='register.jsp';</script>");
				out.close();
				return "add1";
			}
			else if(user.getPassword()==""){
				getResponse().setContentType("text/html; charset=GBK");
				PrintWriter out = getResponse().getWriter();
				out.print("<script language=javascript>alert('请输入密码');window.location.href='register.jsp';</script>");
				out.close();
				return "add1";
			}
			else{
				userService.addSUser(user);
				return SUCCESS;
			}
	}
	
	public String updateUser(){
		
		
		user = userService.getUserById(uid);
		
		return "update";
	}
	//修改
	public String updatedUser(){
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		userService.updateSUser(user);
		session.put("user",user);
		return SUCCESS;
	}
	public String showUser(){
		user = userService.getUserById(uid);
		return SUCCESS;
	}
	//public String deleteUser(){
	//	userService.deleteSUser(uid);
	//	return SUCCESS;
	//}
	//显示用户列表
	public String listUser(){
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		users =  userService.findAllUser(curPage,7);
		pager = userService.getPagerOfAllUser(7);
		pager.setCurPage(curPage);
		return "list";
	}
	public String updateuserpwd(){
		ActionContext ctx = ActionContext.getContext();
		Map session1 = ctx.getSession();
		user = (User) session1.get("user");
		return "updatepwd";
	}
	//修改密码
	public String updateduserpwd() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		Map session1 = ctx.getSession();
		user = (User) session1.get("user");
		if(oldpassword.equals(user.getPassword())){
		
				user.setPassword(password2);
				userService.updateSUser(user);
				session1.put("user",user);
				return SUCCESS;
			
		}else{
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('原密码错误，请重新输入！');window.location.href='updateuserpwd.action';</script>");
			out.close();
			return ERROR;
		}
		
	}
	//修改地址
	public String updateAddress() {
		ActionContext ctx = ActionContext.getContext();
		Map session1 = ctx.getSession();
		user = (User) session1.get("user");
		return "updateaddress";
	}
	public String updatedAddress() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		Map session1 = ctx.getSession();
		user = (User) session1.get("user");
		user.setAddress(address2);
		userService.updateSUser(user);
		session1.put("user",user);
		return SUCCESS;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}	
}
