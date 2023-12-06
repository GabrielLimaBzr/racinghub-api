package com.application.racinghub.common.infra.config.security.domain.model.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestLoginDTO(@NotBlank String login, @NotBlank String password) {
}
