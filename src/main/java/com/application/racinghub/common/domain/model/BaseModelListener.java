package com.application.racinghub.common.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;

public class BaseModelListener {

	@PrePersist
    public void prePersist(BaseModel entity) {
        if (entity.getCreated() == null) {
            entity.setCreated(LocalDateTime.now());
        }
    }
}
