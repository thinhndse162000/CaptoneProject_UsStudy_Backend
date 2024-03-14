package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {
    // secret key
    private final String JWT_SECRET = "sk12000724fds";

    // Time expired of jwt token
    private final long JWT_EXPIRATION = 604800000L;

    // Create token extract customer information to token
    public String generateToken(Customer customer) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + JWT_EXPIRATION);
        // create string token put in information of customer
        return Jwts.builder()
                .setSubject(Integer.toString(customer.getCustomerId()))
                .claim("UserId", customer.getCustomerId())
                .claim("email", customer.getEmail())
                .claim("Role", "ROLE_CUSTOMER")
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String generateTokenConsultant(Consultant consultant) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + JWT_EXPIRATION);
        // create string token put in information of customer
        return Jwts.builder()
                .setSubject(Integer.toString(consultant.getConsultantId()))
                .claim("UserId", consultant.getConsultantId())
                .claim("email", consultant.getEmail())
                .claim("Role", "CONSULTANT")
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // get inforatiom in jwt token
    public String getUserEmailFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("email").toString();
    }

    public String getRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("Role").toString();
    }

    // check tokem valid or not
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getToken(HttpServletRequest httpServletRequest) {
        final String bearerToken = httpServletRequest.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        } // The part after "Bearer "
        return null;
    }
}
