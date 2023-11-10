package com.application.corridahub.comum.domain.model;

public interface BaseModel<T> {

	void update(T source);

	Long getId();

	T createNewInstance();
}
