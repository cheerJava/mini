package com.cheer.mini.tinglin.service;

import java.util.List;



import com.cheer.mini.ums.model.Product;


public interface ProductService {
    
	public void save(Product proInfo);
	
	public void update(Product proInfo);
	
	public List<Product> list(Product condition);
	
	public Product info(String proInfo);
	
	public void delete(String proInfo);
	
	public Integer count(Product condition);

}
