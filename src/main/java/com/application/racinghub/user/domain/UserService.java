package com.application.racinghub.user.domain;

import com.application.racinghub.common.domain.BaseService;
import com.application.racinghub.user.UserFilter;
import com.application.racinghub.user.UserSpecification;
import com.application.racinghub.user.domain.model.User;

public interface UserService extends BaseService<User, UserFilter, UserSpecification> {

}
