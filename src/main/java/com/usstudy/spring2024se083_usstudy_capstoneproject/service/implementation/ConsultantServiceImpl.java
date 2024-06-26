package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ConsultantMapper;
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
                .map(ConsultantMapper.INSTANT::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ConsultantDto> getConsultantFilter(ConsultantFilterRequest request) {
        return repository.getConsultantFilter(request)
                .stream().map(ConsultantMapper.INSTANT::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultantDto getConsultantById(Integer consultantId) {
        return repository.findById(consultantId)
                .map(ConsultantMapper.INSTANT::toDto)
                .orElseThrow(() -> new NullPointerException("Consultant not found - " + consultantId));
    }

    @Override
    public ConsultantDto saveConsultant(ConsultantRequest consultantRequest, Integer id) {
        if (id!=null){
            Consultant consultant=repository.findById(id)
                    .orElseThrow(() -> new NullPointerException("Consultant not found - "+id));
            MergeRequest.mergeIgnoreNullValue(consultantRequest,consultant);
            consultant.setSpecialize(String.join(",", consultantRequest.getSpecialize()));
            return ConsultantMapper.INSTANT.toDto(
                    repository.save(consultant)
            );
        }
        return ConsultantMapper.INSTANT.toDto(
                repository.save(ConsultantMapper.INSTANT.toEntity(consultantRequest))
        );
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
