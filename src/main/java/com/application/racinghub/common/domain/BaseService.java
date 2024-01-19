package com.application.racinghub.common.domain;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BaseService<T, FP, S> {

	T findById(Long id);

	T create(T entity);

	T update(T entity);

	void deleteById(Long id);

	Page<T> filter(FP filter);

	S createSpecification(FP filter);

}
