package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ConsultantService;
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
    private ConsultantService consultantService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            SecurityContextHolder.clearContext();
            String token = tokenProvider.getToken(request);
            if (token != null && tokenProvider.validateToken(token)) {
                String email = tokenProvider.getUserEmailFromJwt(token);
                UserDetails customer = service.loadUserByUsername(email);
                String role = tokenProvider.getRole(token);

                if (customer != null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(customer.getUsername(), null, customer.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    log.info("authenticated user with email :{}", email);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
//            else if (consultant != null) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                        new UsernamePasswordAuthenticationToken(consultant.getUsername(), null, consultant.getAuthorities());
//                log.info("authenticated user with email :{}", email);
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
            }
        } catch (Exception ex) {
            logger.error("failed on set user authentication", ex);
        }
        filterChain.doFilter(request, response);
    }
}
