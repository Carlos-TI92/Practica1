package com.isil.productmanagement.service;

import java.sql.SQLException;
import java.util.List;

import com.isil.productmanagement.model.Product;
import com.isil.productmanagment.dao.ProductDAO;


/**
 * AbstractService.java This SERVICE class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Abel Huarca [Isil]
 *
 */
public class ProductService {

    ProductDAO dao= new ProductDAO();

	public void insertProduct(Product product) throws SQLException {
		dao.insertProduct(product);
		} 

	public Product selectProduct(int id) {
		return dao.selectProduct(id);
	}

	public List<Product> selectAllProducts() {
		return dao.selectAllProducts();
	}

	public boolean deleteProduct(int id) throws SQLException {
		return dao.deleteProduct(id);
	}

	public boolean updateProduct(Product product) throws SQLException {
		return dao.updateProduct(product);
	}

	

}
