package com.application.corridahub.comum.domain.model;

public interface BaseModel<T> extends Auditable {

	Long getId();

	void update(T source);

	T createNewInstance();

}
