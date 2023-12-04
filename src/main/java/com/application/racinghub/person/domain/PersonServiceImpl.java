package com.application.racinghub.person.domain;

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

	protected PersonServiceImpl(PersonRepository repository) {
		super(Person.class, repository);
	}

	@Override
	public PersonSpecification createSpecification(PersonFilter filter) {
		PersonSpecification specification = new PersonSpecification();
		specification.add(new SearchCriteria("name", SearchOperantion.MATCH, filter.getName()));
		specification.setSorting(filter.getOrderBy());
		return specification;
	}

}
