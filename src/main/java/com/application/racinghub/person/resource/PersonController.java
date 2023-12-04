package com.application.racinghub.person.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.racinghub.common.resource.BaseController;
import com.application.racinghub.person.PersonFilter;
import com.application.racinghub.person.PersonSpecification;
import com.application.racinghub.person.domain.PersonService;
import com.application.racinghub.person.domain.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<Person, PersonFilter, PersonSpecification>{

	protected PersonController(final PersonService baseService) {
		super(baseService);
	}

}
