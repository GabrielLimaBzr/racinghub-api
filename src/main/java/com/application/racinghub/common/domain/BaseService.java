package com.application.racinghub.common.domain;

import java.util.List;

public interface BaseService<T> {

	List<T> findAll();

	T findById(Long id);

	T create(T entity);

	T update(T entity);

	void deleteById(Long id);
	
}
