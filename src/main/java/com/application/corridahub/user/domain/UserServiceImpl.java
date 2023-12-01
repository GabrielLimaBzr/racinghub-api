package com.application.corridahub.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.application.corridahub.comum.domain.BaseServiceImpl;
import com.application.corridahub.user.domain.model.User;
import com.application.corridahub.user.infra.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	public UserServiceImpl() {
        super(User.class);
    }
	
	@Autowired
	private UserRepository repository;

	@Override
	protected JpaRepository<User, Long> getRepository() {
		return repository;
	}

}
