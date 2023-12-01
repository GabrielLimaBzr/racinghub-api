package com.application.racinghub.racing.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.application.racinghub.common.domain.BaseServiceImpl;
import com.application.racinghub.racing.domain.model.Racing;
import com.application.racinghub.racing.infra.RacingRepository;

@Service
public class RacingServiceImpl extends BaseServiceImpl<Racing> implements RacingService{

	protected RacingServiceImpl() {
		super(Racing.class);
	}

	@Autowired
	private RacingRepository repository;
	
	@Override
	protected JpaRepository<Racing, Long> getRepository() {
		return repository;
	}


}
