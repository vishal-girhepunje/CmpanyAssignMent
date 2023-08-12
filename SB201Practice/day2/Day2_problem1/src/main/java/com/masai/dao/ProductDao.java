package com.masai.dao;

import com.masai.dto.Product;

public interface ProductDao {
	public Product findProduct(int id);

	public void update(Product p);
	
}
