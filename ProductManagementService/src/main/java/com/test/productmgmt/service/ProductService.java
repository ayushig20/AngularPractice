package com.test.productmgmt.service;

import java.util.List;

import com.test.productmgmt.entities.Product;
import com.test.productmgmt.pojo.ProductDetails;

public interface ProductService {
	public void addProduct(ProductDetails productDetails);
	public List<Product> searchProducts(String productType);
	public boolean deleteProduct(int productId);
}
