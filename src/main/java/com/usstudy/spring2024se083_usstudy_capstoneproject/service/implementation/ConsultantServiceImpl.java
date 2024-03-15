package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ConsultantRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ConsultantServiceImpl implements ConsultantService, UserDetailsService {

    private final ConsultantRepository repository;

    @Autowired
    public ConsultantServiceImpl(ConsultantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant getConsultantByEmail(String email) {
        return repository.getCustomerByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Consultant consultant = repository.getCustomerByEmail(email);
        if (consultant == null) {
            throw new UsernameNotFoundException(String.format("consultant '%s' not found", consultant));
        } else {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_CONSULTANT"));

            return new Customer(consultant.getUsername(), authorities, "ROLE_CONSULTANT");
        }
    }
}
