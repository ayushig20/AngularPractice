package com.sapient.productmgmt.service;

import java.util.List;

import com.sapient.productmgmt.entities.Product;
import com.sapient.productmgmt.pojo.ProductDetails;

public interface ProductService {
	public void addProduct(ProductDetails productDetails);
	public List<Product> searchProducts(String productType);
	public boolean deleteProduct(int productId);
}
