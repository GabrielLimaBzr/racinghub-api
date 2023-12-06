package com.application.racinghub.common.infra.config.security.infra;

import com.application.racinghub.common.infra.config.security.AuthService;
import com.application.racinghub.common.infra.config.security.domain.model.dto.RequestLoginDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid RequestLoginDTO loginDTO) {
        return ResponseEntity.ok(this.authService.Login(loginDTO));
    }
}
