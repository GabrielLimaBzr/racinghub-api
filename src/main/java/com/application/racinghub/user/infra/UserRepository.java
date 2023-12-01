package com.application.racinghub.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.racinghub.user.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
