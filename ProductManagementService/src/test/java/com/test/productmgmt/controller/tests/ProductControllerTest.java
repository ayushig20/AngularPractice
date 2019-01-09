package com.test.productmgmt.controller.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.test.productmgmt.ProductManagementApp;
import com.test.productmgmt.controller.ProductController;
import com.test.productmgmt.entities.Product;
import com.test.productmgmt.pojo.ProductDetails;
import com.test.productmgmt.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProductManagementApp.class })
public class ProductControllerTest {

	@Inject
	ProductService productService;
	ProductController productController = new ProductController();

	@PostConstruct
	public void setup() {

		ReflectionTestUtils.setField(productController, "productService", productService);
	}

	@Test
	public void testAddProduct() {
		productController.addProduct(getProduct());

	}

	@Test
	public void testSearchProduct() {

		List<Product> productList = productController.searchProduct("Type2");
		assertEquals(productList.size(), 0);
	}

	@Test
	public void testDeleteProduct() {

		boolean isDeleted = productController.deleteProduct(101);
		assertEquals(isDeleted, true);
	}

	private ProductDetails getProduct() {
		ProductDetails product = new ProductDetails();
		product.setProductName("Product1");
		product.setProductType("Type2");

		return product;
	}
}
