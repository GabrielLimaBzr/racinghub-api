package com.application.racinghub.person.domain;

import com.application.racinghub.common.domain.BaseService;
import com.application.racinghub.person.PersonFilter;
import com.application.racinghub.person.PersonSpecification;
import com.application.racinghub.person.domain.model.Person;

public interface PersonService extends BaseService<Person, PersonFilter, PersonSpecification> {

}
