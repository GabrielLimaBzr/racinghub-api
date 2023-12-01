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
		specification.add(new SearchCriteria("dateStart", SearchOperantion.DATE_GREATER_THAN_EQUAL, filter.getDateStart()));
		specification.add(new SearchCriteria("dateEnd", SearchOperantion.DATE_LESS_THAN_EQUAL, filter.getDateEnd()));
		specification.setSorting(filter.getOrderBy());
		
		return specification;
	}


}
