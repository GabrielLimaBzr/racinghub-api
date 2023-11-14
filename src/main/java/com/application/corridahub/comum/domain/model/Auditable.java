package com.application.corridahub.comum.domain.model;

import java.time.LocalDateTime;

public interface Auditable {

	LocalDateTime getCreated();

	void setCreated(LocalDateTime created);

}
