package com.devsuperior.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.myfirstproject.entities.Product;

@Component
public class ProductRepository {
	
	private Map<Long, Product> map = new HashMap<Long, Product>();
	
	public void save(Product product) {
		map.put(product.getId(), product);
	}
	
	public Product findById(Long id) {
		return map.get(id); 
	}
	
	public List<Product> findAll(){
		return new ArrayList<Product>(map.values());
	}

}