package com.application.racinghub.racing.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.application.racinghub.racing.domain.model.Racing;

public interface RacingRepository extends JpaRepository<Racing, Long>, JpaSpecificationExecutor<Racing> {

}
