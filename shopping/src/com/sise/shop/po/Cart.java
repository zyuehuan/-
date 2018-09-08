package com.sise.shop.po;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public final class Cart {
		protected Map<Integer,OrderItem> items;
		public Cart(){
				if(items==null) {
					items=new HashMap<Integer,OrderItem>();
				}
		}
		public void addProduct(Integer pid,OrderItem orderitem){
			if(items.containsKey(pid)){
				OrderItem _orderitem = items.get(pid);
				_orderitem.setNumber(_orderitem.getNumber() + orderitem.getNumber());
				items.put(pid, _orderitem);
			}else{
				items.put(pid, orderitem);
			}
		}
		public void updateCart(Integer pid,int number){
			OrderItem orderitem=items.get(pid);
			orderitem.setNumber(number);
			items.put(pid, orderitem);
		}
		public void removeProduct(Integer pid){
			items.remove(pid);
		}
		public void clearCart(){
			items.clear();
		}
		public float getTotalPrice(){
			float totalPrice=0;
			for(Iterator it=items.values().iterator();it.hasNext();){
				OrderItem orderitem=(OrderItem)it.next();
				Product product=orderitem.getProduct();
				int number = orderitem.getNumber();
				totalPrice+=product.getPrice()*number;
			}
			return totalPrice;
		}
		public int getCount(){
			int count = 0;
			for(Iterator it=items.values().iterator();it.hasNext();){
				OrderItem orderitem=(OrderItem)it.next();
				count+=orderitem.getNumber();
			}
			return count;
		}
		public Map<Integer, OrderItem> getItems() {
			return items;
		}
		public void setItems(Map<Integer, OrderItem> items) {
			this.items = items;
		}
}