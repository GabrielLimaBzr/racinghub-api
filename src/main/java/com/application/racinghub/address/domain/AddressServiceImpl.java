package com.application.racinghub.address.domain;

import org.springframework.stereotype.Service;

import com.application.racinghub.address.AddressFilter;
import com.application.racinghub.address.AddressSpecification;
import com.application.racinghub.address.domain.model.Address;
import com.application.racinghub.address.infra.AddressRepository;
import com.application.racinghub.common.SearchCriteria;
import com.application.racinghub.common.BaseSpecification.SearchOperantion;
import com.application.racinghub.common.domain.BaseServiceImpl;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressFilter, AddressSpecification> implements AddressService{

	protected AddressServiceImpl(AddressRepository repository) {
		super(Address.class, repository);
	}

	@Override
	public AddressSpecification createSpecification(AddressFilter filter) {
		AddressSpecification specification = new AddressSpecification();
		specification.add(new SearchCriteria("country", SearchOperantion.EQUAL, filter.getCountry()));
		return specification;
	}

}
