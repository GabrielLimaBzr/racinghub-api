package com.application.racinghub.common.infra.config.security.domain;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserSpringSecurityService userSpringSecurityService;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userSpringSecurityService.findUser(login);
    }
}
