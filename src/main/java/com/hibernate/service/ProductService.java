package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.ProductDao;
import com.hibernate.entity.Product;

public class ProductService {
	ProductDao dao = new ProductDao();

	public boolean saveProduct(Product product) {
		
		return dao.saveProduct(product);
	}

	public Product getProductById(long productId) {
		
		return dao.getProductById(productId);
	}

	public boolean deleteProductById(long productId) {
		boolean isDeleted =dao.deleteProductById(productId);
		return isDeleted;
		
	}

	public boolean updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

	public List<Product> getAllProduct() {
		
		return dao.getAllProduct();
	}

	public List<Product> priceGreterThan() {
		
		return dao. priceGreterThan();
	}

	public List<Product> equalToProductName() {
		
		return dao. equalToProductName();
	}

	public List<Product> likeProductName() {
		
		return dao.likeProductName();
	}

	public List<Product> getProductGretarThanEqual() {
		
		return dao.getProductGretarThanEqual();
	}

	public List<Product> getProductGretarThan() {
		
		return dao.getProductGretarThan();
	}

	public List<Product> getProductLessThanEqual() {
		
		return dao.getProductLessThanEqual();
	}

	public List<Product> getProductLessThan() {
		
		return dao.getProductLessThan();
	}

	public List<Product> sameProductName() {
		
		return dao.sameProductName();
	}

	public List<Product> producOrderByAsce() {
		
		return dao.producOrderByAsce();
	}

	public List<Product> producOrderByDesc() {
		
		return dao.producOrderByDesc();
	}

	public List<Product> producIsNotPresent() {
		
		return dao.producIsNotPresent();
	}

	public List<Product> producIsPresent() {
		
		return dao.producIsPresent();
	}

	public List<Product> productInBetween() {
		
		return dao.productInBetween();
	}

	public List<Product> productIsNull() {
		
		return  dao.productIsNull() ;
	}

	public List<Product> productIsNotNull() {
		
		return dao.productIsNotNull();
	}

	public List<Product> productIsEmpty() {
		
		return dao. productIsEmpty();
	}

	public List<Product> productTotalRowCount() {
		
		return dao.productTotalRowCount();
	}

	

	}

