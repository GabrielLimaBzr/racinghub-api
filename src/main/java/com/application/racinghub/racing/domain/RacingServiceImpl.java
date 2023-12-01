package com.application.racinghub.racing.domain;

import org.springframework.stereotype.Service;

import com.application.racinghub.common.SearchCriteria;
import com.application.racinghub.common.BaseSpecification.SearchOperantion;
import com.application.racinghub.common.domain.BaseServiceImpl;
import com.application.racinghub.racing.RacingFilter;
import com.application.racinghub.racing.RacingSpecification;
import com.application.racinghub.racing.domain.model.Racing;
import com.application.racinghub.racing.infra.RacingRepository;

@Service
public class RacingServiceImpl extends BaseServiceImpl<Racing, RacingFilter, RacingSpecification> implements RacingService{

	protected RacingServiceImpl(RacingRepository repository) {
		super(Racing.class, repository);
	}

	@Override
	public RacingSpecification createSpecification(RacingFilter filter) {
		RacingSpecification specification = new RacingSpecification();
		specification.add(new SearchCriteria("racing", SearchOperantion.MATCH, filter.getRacing()));
		return specification;
	}


}
