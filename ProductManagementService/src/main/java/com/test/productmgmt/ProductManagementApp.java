package com.test.productmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductManagementApp {
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApp.class, args);
	}
}
