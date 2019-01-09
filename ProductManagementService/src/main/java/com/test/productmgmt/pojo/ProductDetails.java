package com.test.productmgmt.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetails {
	@JsonProperty("productType")
	@NotEmpty(message = "productType must not be empty")
	private String productType = null;

	@JsonProperty("productName")
	@NotEmpty(message = "productName must not be empty")
	private String productName = null;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductDetails [productType=" + productType + ", productName=" + productName + "]";
	}

}
