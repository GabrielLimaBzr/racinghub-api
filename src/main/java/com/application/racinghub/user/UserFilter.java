package com.application.racinghub.user;

import com.application.racinghub.common.domain.BaseFilter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilter extends BaseFilter {
	
	private String email;

}
