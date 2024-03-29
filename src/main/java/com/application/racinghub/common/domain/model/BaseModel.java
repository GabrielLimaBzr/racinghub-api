package com.application.racinghub.common.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel {
	
	public abstract Long getId();

    public abstract void setId(Long id);
    
    public abstract LocalDateTime getCreated();

    public abstract void setCreated(LocalDateTime created);
	
}
