package com.application.racinghub.address.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.racinghub.address.AddressFilter;
import com.application.racinghub.address.AddressSpecification;
import com.application.racinghub.address.domain.AddressService;
import com.application.racinghub.address.domain.model.Address;
import com.application.racinghub.common.resource.BaseController;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address, AddressFilter, AddressSpecification>{

	protected AddressController(final AddressService baseService) {
		super(baseService);
	}

}
