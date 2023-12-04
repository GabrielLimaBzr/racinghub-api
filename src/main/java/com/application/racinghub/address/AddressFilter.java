package com.application.racinghub.address;

import com.application.racinghub.common.domain.BaseFilter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressFilter extends BaseFilter {

	private String country;
}
