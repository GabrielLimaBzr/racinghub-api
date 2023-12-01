package com.application.corridahub.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.corridahub.user.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
