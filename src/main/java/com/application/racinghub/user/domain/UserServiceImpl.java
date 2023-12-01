package com.application.racinghub.user.domain;

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

	public UserServiceImpl(UserRepository repository) {
		super(User.class, repository);
	}

	@Override
	public UserSpecification createSpecification(UserFilter filter) {
		UserSpecification specification = new UserSpecification();
		specification.add(new SearchCriteria("email", SearchOperantion.EQUAL, filter.getEmail()));
		return specification;
	}
}
