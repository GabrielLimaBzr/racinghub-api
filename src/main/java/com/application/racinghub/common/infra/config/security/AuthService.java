package com.application.racinghub.common.infra.config.security;

import com.application.racinghub.common.infra.config.security.domain.model.dto.RequestLoginDTO;
import com.application.racinghub.common.infra.util.Utils;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    public String Login(RequestLoginDTO loginDTO) {
        String login = loginDTO.login();
        if (Utils.isValidDocument(loginDTO.login())) {
            login = Utils.removeSpecialCharacters(loginDTO.login());
        }
        Authentication auth = new UsernamePasswordAuthenticationToken(login, loginDTO.password());
        this.authenticationManager.authenticate(auth);
        return "Login successfully";
    }
}
