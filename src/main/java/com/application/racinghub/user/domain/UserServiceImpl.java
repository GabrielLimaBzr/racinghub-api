package com.application.racinghub.user.domain;

import com.application.racinghub.person.domain.PersonService;
import com.application.racinghub.person.infra.PersonRepository;
import org.springframework.stereotype.Service;

import com.application.racinghub.common.SearchCriteria;
import com.application.racinghub.common.BaseSpecification.SearchOperantion;
import com.application.racinghub.common.domain.BaseServiceImpl;
import com.application.racinghub.user.UserFilter;
import com.application.racinghub.user.UserSpecification;
import com.application.racinghub.user.domain.model.User;
import com.application.racinghub.user.infra.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserFilter, UserSpecification> implements UserService {

	private final UserRepository repository;

	private final PersonService personService;

	public UserServiceImpl(UserRepository repository, PersonService personService) {
		super(User.class, repository);
		this.repository = repository;
		this.personService = personService;
	}

	@Override
	public UserSpecification createSpecification(UserFilter filter) {
		UserSpecification specification = new UserSpecification();
		specification.add(new SearchCriteria("email", SearchOperantion.EQUAL, filter.getEmail()));
		return specification;
	}

	public User findUserByDocument(String document) {
		return this.repository.findUserByDocument(document);
	}

	public User findUserByEmail(String email) {
		return this.repository.findUserByEmail(email);
	}

	@Override
	public User create(User entity) {
		personService.create(entity.getPerson());
		return super.create(entity);
	}
}
