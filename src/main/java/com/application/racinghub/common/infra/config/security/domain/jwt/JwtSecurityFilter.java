package com.application.racinghub.common.infra.config.security.domain.jwt;

import com.application.racinghub.common.infra.config.security.domain.UserDetailsServiceImp;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private UserDetailsServiceImp userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String login = this.jwtTokenService.validateJwtToken(getToken(request));
        if (login != null) {
            UserDetails user = this.userDetailsService.loadUserByUsername(login);
            if (user != null) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var authenticationHeader = request.getHeader("Authentication");
        if (authenticationHeader == null) return null;
        return authenticationHeader.replace("Bearer ", "");
    }
}
