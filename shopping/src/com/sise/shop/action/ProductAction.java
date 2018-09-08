package com.sise.shop.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.shop.po.Product;
import com.sise.shop.service.ProductService;
import com.sise.shop.service.impl.ProductServiceImpl;
import com.sise.shop.vo.Pager;

@Scope("prototype")
public class ProductAction extends ActionSupport implements ModelDriven{
    @Resource
    private ProductService productService;
    private int pid;
	private int type;
	private String keyword;
	private Pager pager;
    private File upload;// 上传的文件
    private String uploadFileName;//上传的文件名陈
    private String uploadContentType;// 接收文件上传的MIME类型
   
	private Product product = new Product();
	private List<Product> products =new ArrayList<Product>();
	@Override
	public Object getModel() {
		
		return product;
	}
   public ProductAction(){
	   productService=new ProductServiceImpl();
   }
   protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
   public String addInputProduct(){
		
		return "addInput";
	}
   //添加商品
   public String addProduct() throws Exception{
		
			int curPage = 1;
			if(pager!=null)
				curPage = pager.getCurPage();
			if(upload != null){    
	            // 将图片上传到服务器上.    
	            // 获得上传图片的服务器端路径.    
	            String path = ServletActionContext.getServletContext().getRealPath("/upload");    
	            // 创建文件类型对象:    
	            File diskFile = new File(path + "//" + uploadFileName);    
	            // 文件上传:    
	            FileUtils.copyFile(upload, diskFile);    
	            product.setPath("upload/" + uploadFileName);  
	        }    

	        productService.addSProduct(product);
	        products = productService.findAllProduct(curPage,4);
	       
			return SUCCESS;
		
   }
   public String updateProduct(){
		
		product = productService.getProductById(pid);
		
		return "update";
	}
	
	public String updatedProduct()throws Exception{
		
		productService.updateSProduct(product);
		return SUCCESS;
	}
	
	public String deleteProduct(){
		
		productService.deleteSProduct(pid);
		return SUCCESS;
	}
	public String showProduct(){
		product=productService.getProductById(pid);
		return "show";
	}
	//关键字搜索
	public String listKeywordProduct(){
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		keyword = product.getKeyword();
		
		products =  productService.findSProductByName(keyword,curPage,8);
		pager = productService.findPagerSProductByName(keyword,8);
		pager.setCurPage(curPage); 
		return SUCCESS;
	}
	public String listProduct(){
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		
		if( type == -1 || type == 0){
			products = productService.findAllProduct(curPage,4);
			pager = productService.getPagerOfAllProduct(4);
		}else{
			products = productService.getSProductByCatagoryId(type,curPage,4);
			pager = productService.getPagerSProductByCatagoryId(type, 4);
		}
		pager.setCurPage(curPage);
		return "list";
	}
	//首页
		public String index(){
			int curPage = 1;
			if(pager!=null)
				curPage = pager.getCurPage();
		
			products = productService.findAllProduct(curPage,12);
			pager = productService.getPagerOfAllProduct(12);
			pager.setCurPage(curPage);
			return "index";
		}
	public String listallProduct(){
		int curPage = 1;
		if(pager!=null)
			curPage = pager.getCurPage();
		
		if( type == -1 || type == 0){
			products = productService.findAllProduct(curPage,8);
			pager = productService.getPagerOfAllProduct(8);
		}else{
			products = productService.getSProductByCatagoryId(type,curPage,8);
			pager = productService.getPagerSProductByCatagoryId(type, 8);
		}
		pager.setCurPage(curPage);
		return "list";
	}
	public String indexlistProduct(){
		int curPage = 1;
		if(pager!=null)
		curPage = pager.getCurPage();
		type=product.getType();
		if(type==0){
			products = productService.findAllProduct(curPage,8);
			pager = productService.getPagerOfAllProduct(8);
		}
		else{	
		products = productService.getSProductByCatagoryId(type,curPage,8);
		pager = productService.getPagerSProductByCatagoryId(type, 8);

		pager.setCurPage(curPage);
		}
		return "indexlistp";
		
	}
	
	public String productdetail(){
		
		product = productService.getProductById(pid);
		return "detail";
	}
	



	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
