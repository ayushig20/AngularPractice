package com.test.productmgmt.util;

/**
 * Custom SearchCriteria is used for the Product<br>
 * <br>
 * 
 * Note that This ProductSearchCriteria is used to define all Search Criteria
 * related to Product.
 * 
 * @author gupta.as
 */
public class ProductSearchCriteria {

	public ProductSearchCriteria() {
		super();
	}

	public ProductSearchCriteria(String key, String operation, Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public ProductSearchCriteria(String key, String operation) {
		super();
		this.key = key;
		this.operation = operation;
	}

	private String key;
	private String operation;
	private Object value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ProductSearchCriteria [key=" + key + ", operation=" + operation + ", value=" + value + "]";
	}
}
