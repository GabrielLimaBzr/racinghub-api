package com.application.racinghub.racing.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.racinghub.common.resource.BaseController;
import com.application.racinghub.racing.domain.RacingService;
import com.application.racinghub.racing.domain.model.Racing;

@RestController
@RequestMapping("/racing")
public class RacingController extends BaseController<Racing>{

	protected RacingController(final RacingService service) {
		super(service);
	}

}
