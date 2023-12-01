package com.application.corridahub.user.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.corridahub.comum.resource.BaseController;
import com.application.corridahub.user.domain.UserService;
import com.application.corridahub.user.domain.model.User;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {
	
	protected UserController(final UserService service) {
		super(service);
	}
	
}
