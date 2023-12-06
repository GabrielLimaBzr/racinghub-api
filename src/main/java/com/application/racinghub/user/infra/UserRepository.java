package com.application.racinghub.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.application.racinghub.user.domain.model.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("SELECT u FROM User u WHERE u.person.document = ?1")
    User findUserByDocument(String document);

    @Query("SELECT u FROM User u WHERE u.person.email = ?1")
    User findUserByEmail(String email);
}
