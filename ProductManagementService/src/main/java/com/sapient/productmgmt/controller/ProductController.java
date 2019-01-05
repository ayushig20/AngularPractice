package com.sapient.productmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sapient.productmgmt.entities.Product;
import com.sapient.productmgmt.pojo.ProductDetails;
import com.sapient.productmgmt.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/productservice/addproduct", consumes = {
			"application/json" }, method = RequestMethod.POST)
	public void addProduct(@RequestBody(required = true) @Valid ProductDetails product) {
		productService.addProduct(product);
	}

	@RequestMapping(value = "/productservice/getproducts/{productType}", method = RequestMethod.GET, produces = {
			"application/json" })
	public List<Product> searchProduct(@PathVariable(value = "productType", required = true) String productType) {
		return productService.searchProducts(productType);
	}

	@RequestMapping(value = "/productservice/deleteproducts/{productid}", method = RequestMethod.DELETE)
	public boolean deleteProduct(@PathVariable(value = "productid", required = true) int productId) {

		return productService.deleteProduct(productId);
	}

}
