package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<ConsultantDto> getAllConsultant() {
        return repository.findAll()
                .stream()
                .map(ConsultantDto::convert).collect(Collectors.toList());
    }

    @Override
    public List<ConsultantDto> getConsultantFilter(ConsultantFilterRequest request) {
        return repository.getConsultantFilter(request)
                .stream().map(ConsultantDto::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultantDto getConsultantById(Integer consultantId) {
        return repository.findById(consultantId)
                .map(ConsultantDto::convert)
                .orElseThrow(() -> new NullPointerException("Consultant not found - " + consultantId));
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
