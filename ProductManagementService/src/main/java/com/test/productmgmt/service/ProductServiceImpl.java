package com.test.productmgmt.service;

import java.util.ArrayList;
import java.util.List;

import com.test.productmgmt.entities.Product;
import com.test.productmgmt.pojo.ProductDetails;
import com.test.productmgmt.util.ProductSearchCriteria;
import com.test.productmgmt.util.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.productmgmt.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	@Override
	public void addProduct(ProductDetails productDetails) {
		Product product = new Product();
		product.setName(productDetails.getProductName());
		product.setType(productDetails.getProductType());
		productRepository.saveAndFlush(product);
	}

	@Override
	public List<Product> searchProducts(String productType) {
		List<ProductSearchCriteria> searchCriteriaList = new ArrayList<>();

		ProductSearchCriteria typeSearchCriteria = new ProductSearchCriteria("type", "=", productType);
		searchCriteriaList.add(typeSearchCriteria);

		ProductSpecification<Product> productSpecification = new ProductSpecification<>(searchCriteriaList);

		List<Product> downloads = productRepository.findAll(productSpecification);

		return downloads;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public boolean deleteProduct(int productId) {
		productRepository.delete(productId);
		return true;
	}

}
