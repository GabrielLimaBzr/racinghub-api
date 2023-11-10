package com.application.corridahub.comum.domain;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BaseService<T> {

	List<T> findAll();

	T findById(Long id);

	T create(T entity);

	T update(T entity);

	void deleteById(Long id);
	
	Page<T> findWithFilter(T entity);

}
