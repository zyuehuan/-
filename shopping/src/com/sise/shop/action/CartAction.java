package com.sise.shop.action;

import java.io.PrintWriter;
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
import com.sise.shop.po.Cart;
import com.sise.shop.po.OrderItem;
import com.sise.shop.po.Product;
import com.sise.shop.po.ShoppingCar;
import com.sise.shop.po.User;
import com.sise.shop.service.ProductService;
import com.sise.shop.service.ShoppingCarService;
import com.sise.shop.service.impl.ProductServiceImpl;
import com.sise.shop.service.impl.ShoppingCarServiceImpl;

@Scope("prototype")
public class CartAction extends ActionSupport{
	@Resource private ProductService productService;
	@Resource private ShoppingCarService shoppingCarService;
	private Integer pid;
	private int number;
	public CartAction(){
		productService = new ProductServiceImpl();
		shoppingCarService=new ShoppingCarServiceImpl();
	}
	ServletRequest request = ServletActionContext.getRequest();
	HttpSession session = getRequest().getSession(true);
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	protected HttpSession getSession() {
		return getRequest().getSession(false);
	}
	public String addToCart() throws Exception{
		if((String) session.getAttribute("username")==null||(String) session.getAttribute("username")==""){
			getResponse().setContentType("text/html; charset=GBK");
			PrintWriter out = getResponse().getWriter();
			out.print("<script language=javascript>alert('请您先登录');window.location.href='login.jsp';</script>");
			out.close();
			return "login";
		}else{
			Product product=productService.getProductById(pid);
			OrderItem orderitem=new OrderItem();
			orderitem.setProduct(product);
			product.getOrderitems().add(orderitem);
			orderitem.setNumber(number);
			Map session=ActionContext.getContext().getSession();
			Cart cart=(Cart)session.get("cart");
			
			ShoppingCar shoppingCar=new ShoppingCar();
			if(cart==null){
				cart=new Cart();
		}  
		
			
			//shoppingCarService.addShoppingCar(shoppingCar);
			cart.addProduct(pid, orderitem);
			session.put("cart",cart);
			return SUCCESS;
		}
	}
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.updateCart(pid, number);
		session.put("cart", cart);
		return SUCCESS;
	}
	public String removeCartproduct() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.removeProduct(pid);
		session.put("cart", cart);
		return SUCCESS;
	}
	public String clearCart(){
		Map session=ActionContext.getContext().getSession();
        Cart cart = (Cart)session.get("cart");
        cart.clearCart();
        return "clearCartSuccess";
    }
	public String listCart(){
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		session.put("cart", cart);
		return SUCCESS;
	}
	public String getShoppingCars(){
		return SUCCESS;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
