package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.ConsultantServiceImpl;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.CustomerServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private CustomerServiceImpl service;
    @Autowired
    private ConsultantServiceImpl consultantService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            SecurityContextHolder.clearContext();
            String token = tokenProvider.getToken(request);
            if (token != null && tokenProvider.validateToken(token)) {
                String email = tokenProvider.getUserEmailFromJwt(token);
                String role = tokenProvider.getRole(token);
                if (role.equals("ROLE_CUSTOMER")) {
                    UserDetails customer = service.loadUserByUsername(email);
                    if (customer != null) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(customer.getUsername(), null, customer.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        log.info("authenticated user with email :{}", email);
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                } else if (role.equals("ROLE_CONSULTANT")) {
                    UserDetails consultant = consultantService.loadUserByUsername(email);
                    if (consultant != null) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(consultant.getUsername(), null, consultant.getAuthorities());
                        log.info("authenticated user with email :{}", email);
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }

            }
        } catch (Exception ex) {
            logger.error("failed on set user authentication", ex);
        }
        filterChain.doFilter(request, response);
    }
}
