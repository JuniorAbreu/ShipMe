package com.estacio.userRegistry.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.userRegistry.Model.Product;
import com.estacio.userRegistry.Repository.ProductRepository;

@Transactional
@Repository("productDAO")
public class ProductDAO  extends AbstractDAO<Product> implements ProductRepository {

	public ProductDAO() {
		super(Product.class);
	}

	@Override
	public Product save(Product product) {
		return super.merge(product);
	}
	
	@Override
	public List<Product> list() {
		return super.list();
	}
	
	@Override
	public void delete(Product product) {
		super.delete(product, product.getId());
	}

}
