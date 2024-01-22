package com.application.racinghub.person.domain;

import com.application.racinghub.address.domain.AddressService;
import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Service;

import com.application.racinghub.common.BaseSpecification.SearchOperantion;
import com.application.racinghub.common.SearchCriteria;
import com.application.racinghub.common.domain.BaseServiceImpl;
import com.application.racinghub.person.PersonFilter;
import com.application.racinghub.person.PersonSpecification;
import com.application.racinghub.person.domain.model.Person;
import com.application.racinghub.person.infra.PersonRepository;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonFilter, PersonSpecification> implements PersonService{
	private final AddressService addressService;

	public PersonServiceImpl(PersonRepository repository, AddressService addressService) {
		super(Person.class, repository);
		this.addressService = addressService;
	}

	@Override
	public PersonSpecification createSpecification(PersonFilter filter) {
		PersonSpecification specification = new PersonSpecification();
		specification.add(new SearchCriteria("name", SearchOperantion.MATCH, filter.getName()));
		specification.setSorting(filter.getOrderBy());
		return specification;
	}

	@Override
	public Person create(Person entity) {
		addressService.create(entity.getAddress());
		return super.create(entity);
	}
}
