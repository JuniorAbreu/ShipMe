package com.estacio.shipMe.Repository;

import java.util.List;

import com.estacio.shipMe.Model.Product;

public interface ProductRepository {
	
	public Product save(Product product);
	public List<Product> list();
	public void delete(Product product);

}
