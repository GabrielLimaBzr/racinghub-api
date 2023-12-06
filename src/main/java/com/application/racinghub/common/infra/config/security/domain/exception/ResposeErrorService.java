package com.application.racinghub.common.infra.config.security.domain.exception;

import com.application.racinghub.common.infra.CustomExceptionResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResposeErrorService {

    public void createResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        response.getWriter().print(new CustomExceptionResponse(message, status).toJSON());
    }
}
