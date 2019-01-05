package com.sapient.productmgmt.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification<T> implements Specification<T> {

	public ProductSearchCriteria searchCriteria;

	public List<ProductSearchCriteria> searchCriteriaList;

	public ProductSpecification(List<ProductSearchCriteria> searchCriteriaList) {
		this.searchCriteriaList = searchCriteriaList;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		for (ProductSearchCriteria criteria : searchCriteriaList) {
			predicates.add(builder.equal(root.<String> get(criteria.getKey()), criteria.getValue().toString()));
		}

		return builder.and(predicates.toArray(new Predicate[] {}));
	}

}
