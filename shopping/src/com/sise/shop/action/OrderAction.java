package com.sise.shop.action;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.shop.po.Cart;
import com.sise.shop.po.Count;
import com.sise.shop.po.Order;
import com.sise.shop.po.OrderItem;
import com.sise.shop.po.OrderState;
import com.sise.shop.po.Product;
import com.sise.shop.po.ShoppingCar;
import com.sise.shop.po.User;
import com.sise.shop.service.OrderService;
import com.sise.shop.service.ProductService;
import com.sise.shop.service.UserService;
import com.sise.shop.service.impl.OrderServiceImpl;
import com.sise.shop.vo.Pager;

@Scope("prototype")
public class OrderAction extends ActionSupport{
	@Resource private OrderService orderService;
	@Resource private ProductService productService;
	@Resource private UserService userService;
	private Order order=new Order();
	private Integer oid;
	private Integer uid;
	private int osid;
	private Integer pid;
	private int number;
	private Count count = new Count();
	public int getOsid() {
		return osid;
	}
	public void setOsid(int osid) {
		this.osid = osid;
	}
	private Pager pager;
	private OrderItem orderItem=new OrderItem();
	private List<Order> orders =new ArrayList<Order>();
	private List<OrderItem> orderitems = new ArrayList<OrderItem>();
	public OrderAction(){
		orderService = new OrderServiceImpl();
	}
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
		
	}
	public String checkout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		
		if(user==null || cart==null){
			getResponse().setContentType("text/html; charset=GBK");
		PrintWriter out = getResponse().getWriter();
		out.print("<script language=javascript>alert('购物车为空');window.location.href='getShoppingCars.action';</script>");
		out.close();
		return ERROR;}
		
		Order order=new Order();
		order.setTime(new Date());
		order.setUser(user);
		order.setTotalPrices(cart.getTotalPrice());
		order.setCountproduct(cart.getCount());
		for(Iterator it =cart.getItems().values().iterator();it.hasNext();){
			OrderItem orderitem=(OrderItem)it.next();
			orderitem.setOrder(order);
			order.getOrderitems().add(orderitem);
		}
		OrderState state = new OrderState();
		state.setOsid(1);
		order.setOrderstate(state);
		
		orderService.addOrder(order);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		session.remove(cart);
		
		return SUCCESS;
		}
	public String checkout2() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart1=(Cart)session.get("cart1");
		if(user==null || cart1==null){
			getResponse().setContentType("text/html; charset=GBK");
		PrintWriter out = getResponse().getWriter();
		out.print("<script language=javascript>alert('购物车为空');window.location.href='getShoppingCars.action';</script>");
		out.close();
		return ERROR;}
		
		Order order=new Order();
		order.setTime(new Date());
		order.setUser(user);
		order.setTotalPrices(cart1.getTotalPrice());
		order.setCountproduct(cart1.getCount());
		for(Iterator it =cart1.getItems().values().iterator();it.hasNext();){
			OrderItem orderitem=(OrderItem)it.next();
			orderitem.setOrder(order);
			order.getOrderitems().add(orderitem);
		}
		OrderState state = new OrderState();
		state.setOsid(1);
		order.setOrderstate(state);
		
		orderService.addOrder(order);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		session.remove(cart1);
		
		return SUCCESS;
		}
	public String addOrder() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		if(cart==null)
		{
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('您的购物车没有商品！');window.location.href='listCart.action';</script>");
			out.close();
			return ERROR;
		}
		else{ 
			session.put("cart", cart);
			return SUCCESS;
	
		}
		
	}
	public String buy() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user==null){
			getResponse().setContentType("text/html; charset=GBK");
		PrintWriter out = getResponse().getWriter();
		out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
		out.close();
		return ERROR;}
		else{
			Product product=productService.getProductById(pid);
			OrderItem orderitem=new OrderItem();
			orderitem.setProduct(product);
			product.getOrderitems().add(orderitem);
			orderitem.setNumber(number);		
			Cart cart1=(Cart)session.get("cart1");
	
			if(cart1==null){
				cart1=new Cart();
		}  
	
			cart1.addProduct(pid, orderitem);
			session.put("cart1",cart1);
			return SUCCESS;
		}
	}
	public String shoppingRecord() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user==null){
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
			out.close();
		}
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		orders=orderService.findSOrderByUseridOrstate(user.getId(),osid,curPage,6);
		pager = orderService.getPagerOfOrderByUseridOrstate(user.getId(),osid, 6);
		pager.setCurPage(curPage);
		return SUCCESS;
		
	}
	public String pay() throws Exception{
		Map session=ActionContext.getContext().getSession();
		
		Order order = new Order();
		order = orderService.findSOrderByid(oid);
		OrderState state = new OrderState();
		state.setOsid(2);
		order.setOrderstate(state);
		orderService.updateSOrder(order);
		session.remove("order");
		return SUCCESS;
	}
	public String listOrder() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user==null){
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
			out.close();
		}
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		orders=orderService.findSOrderByUserid(user.getId(),curPage,6);
		pager = orderService.getPagerOfOrderByUserid(user.getId(), 6);
		pager.setCurPage(curPage);
		return SUCCESS;
	}
	public String orderRecord() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(user==null){
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
			out.close();
		}
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		orders=orderService.findSOrderByUserid(user.getId(),curPage,6);
		pager = orderService.getPagerOfOrderByUserid(user.getId(), 6);
		pager.setCurPage(curPage);
		return SUCCESS;
	}
	public String pendDelivery() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
	
		if(user==null){
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
			out.close();
		}
		int curPage = 1;
		if(pager!=null)
		curPage = pager.getCurPage();
		orderitems=orderService.fingSAllstates();
		if(osid==0){
		orders=orderService.findSOrderByUserid(user.getId(),curPage,6);
		pager = orderService.getPagerOfOrderByUserid(user.getId(), 6);
		pager.setCurPage(curPage);
		}
		else{
			orders=orderService.findSOrderByUseridOrstate(user.getId(),osid,curPage,6);
			pager = orderService.getPagerOfOrderByUseridOrstate(user.getId(),osid, 6);
			pager.setCurPage(curPage);
		}
		return SUCCESS;
	}
	public String counts(){
		Map session=ActionContext.getContext().getSession();
		User user=userService.getUserById(uid);
		count.setAllcount(orderService.findSOrderByUserid(user.getId()));
		count.setOsidcount1(orderService.findSOrderByUseridAndStateid(user.getId(), 1));
		count.setOsidcount2(orderService.findSOrderByUseridAndStateid(user.getId(), 2));
		count.setOsidcount3(orderService.findSOrderByUseridAndStateid(user.getId(), 3));
		count.setTotalpricess(orderService.findCountOrderPriceByUserid(user.getId()).toString());
		count.setProcount(orderService.findCountOrderProductByUserid(user.getId()).toString());
		DecimalFormat df=new DecimalFormat(".##");
		double a = orderService.findmonthPriceByUserid(user.getId(),new Date(),new Date());
		String st=df.format(a);
		count.setMontprices(st);
		count.setMontproducts(orderService.findmonthProductByUserid(user.getId(),new Date(),new Date()));
		Date da = new Date();
		da.setMonth(da.getMonth()-1);
		double b = orderService.findmonthPriceByUserid(user.getId(),da,da);
		String st1=df.format(b);
		count.setLastmontprices(st1);
		Date da2 = new Date();
		da2.setMonth(da2.getMonth()-1);
		count.setLastmontproducts(orderService.findmonthProductByUserid(user.getId(),da2,da2));
		return SUCCESS;
	}
	public String countCenter(){
		Map session=ActionContext.getContext().getSession();
		
		
		count.setTotalpricess(orderService.findCountOrderPrice().toString());
		count.setProcount(orderService.findCountOrderProduct().toString());
		DecimalFormat df=new DecimalFormat(".##");
		double a = orderService.findmonthPrice(new Date(),new Date());
		String st=df.format(a);
		count.setMontprices(st);
		count.setMontproducts(orderService.findmonthProduct(new Date(),new Date()));
		
		
		return SUCCESS;
	}
	public String orderDetail(){
		order = orderService.findSOrderByid(oid);
		return SUCCESS;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getPid() {
		return pid;
	}
	public int getNumber() {
		return number;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Count getCount() {
		return count;
	}
	public void setCount(Count count) {
		this.count = count;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
}
