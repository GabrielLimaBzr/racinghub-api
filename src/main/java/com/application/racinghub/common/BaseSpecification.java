package com.application.racinghub.common;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.application.racinghub.common.domain.exception.BadRequestException;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public abstract class BaseSpecification<T> implements Specification<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum SearchOperantion {
		DATE_GREATER_THAN_EQUAL,
		DATE_LESS_THAN_EQUAL,
		MATCH,
		EQUAL,
		JOIN
	}

	private List<SearchCriteria> criteriaList = new ArrayList<>();
	private String sortColumn;
	private Direction sortDirection;
	
	public void setSorting(String orderBy) {
		String regex = "[^,]+,[^,]+";

		if (StringUtils.isNotBlank(orderBy)) {
			if (!orderBy.matches(regex)) {
				throw new BadRequestException("Formato de ordenação inválido");
			}

			String[] sorting;
			sorting = orderBy.split(",", 2);
			this.sortColumn = sorting[0];
			this.sortDirection = Direction.fromString(sorting[1]);
		}
	}

	public void add(SearchCriteria criteria) {
		if (criteria.getValue() != null && StringUtils.isNotBlank(criteria.getValue().toString())) {
			criteriaList.add(criteria);
		}
	}

	protected void addJoinCriteria(SearchCriteria criteria, CriteriaBuilder criteriaBuilder, Root<T> root, List<Predicate> predicates, Object value) {}
	
	protected void prepareBeforeQuery(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {}
	

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<>();
		prepareBeforeQuery(root, query, criteriaBuilder, predicates);
		

		for (SearchCriteria criteria : criteriaList) {
			String key = criteria.getKey();
			Object value = criteria.getValue();

			switch (criteria.getOperation()) {
			case DATE_GREATER_THAN_EQUAL:
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<LocalDateTime>get(key), (LocalDateTime)value));
				break;
			case DATE_LESS_THAN_EQUAL:
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<LocalDateTime>get(key), (LocalDateTime)value));
				break;
			case EQUAL:
				predicates.add(criteriaBuilder.equal(root.get(key), value));
				break;
			case MATCH:
				predicates.add(criteriaBuilder.like(root.get(key), "%" + value.toString() + "%"));
				break;
			case JOIN:
				addJoinCriteria(criteria, criteriaBuilder, root, predicates, value);
				break;
			default:
				break;
			}
		}

		if (sortColumn != null && sortDirection != null) {
			Path<Object> sortPath = root.get(sortColumn);
			Order sortOrder = sortDirection == Direction.ASC ? criteriaBuilder.asc(sortPath)
					: criteriaBuilder.desc(sortPath);
			query.orderBy(sortOrder);
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

	}
}
