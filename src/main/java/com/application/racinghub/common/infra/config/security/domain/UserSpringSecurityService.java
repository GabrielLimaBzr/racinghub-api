package com.application.racinghub.common.infra.config.security.domain;

import com.application.racinghub.common.infra.config.security.domain.model.UserSpringSecurity;
import com.application.racinghub.common.infra.util.Utils;
import com.application.racinghub.user.domain.UserServiceImpl;
import com.application.racinghub.user.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSpringSecurityService {

    private final UserServiceImpl userService;

    public UserDetails findUser(String userLogin) {
        if (Utils.isValidEmail(userLogin)) {
            User user = userService.findUserByEmail(userLogin);
            if (user != null) return new UserSpringSecurity(user.getPerson().getEmail(), user.getPassHash(), user.getRole());
        }
        if (Utils.isValidDocument(userLogin)) {
            User user = userService.findUserByDocument(userLogin);
            if (user != null) return new UserSpringSecurity(user.getPerson().getDocument(), user.getPassHash(), user.getRole());
        }
        return null;
    }

    public String findUserEmail(String login) {
        if (Utils.isValidEmail(login)) return login;
        return userService.findUserByDocument(login).getPerson().getEmail();
    }
}
