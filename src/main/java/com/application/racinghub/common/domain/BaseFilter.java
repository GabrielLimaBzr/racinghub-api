package com.application.racinghub.common.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseFilter {
	private int page = 0;
	private int size = 10;
	private String orderBy;
}
