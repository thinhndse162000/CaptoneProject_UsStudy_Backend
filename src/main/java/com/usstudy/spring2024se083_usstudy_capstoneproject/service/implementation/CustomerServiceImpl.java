package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CustomerRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SignupRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.CustomerMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void CustomerRegistedAccount(SignupRequest request) {
        Customer customer = new Customer();

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setGender(request.getGender());
        customer.setPassword(request.getPassword());
        customer.setDateOfBirth(request.getDateOfBirth());
        customer.setPhone(request.getPhone());

        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper.INSTANT::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .map(CustomerMapper.INSTANT::toDto)
                .orElseThrow(() -> new NullPointerException("Customer not found - " + customerId));
    }

    @Override
    public CustomerDto updateCustomer(CustomerRequest customerRequest,Integer id) {
        Customer customer=customerRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Customer id - "+id));
        MergeRequest.mergeIgnoreNullValue(customerRequest,customer);
        return CustomerMapper.INSTANT.toDto(customerRepository.save(customer));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.getCustomerByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException(String.format("customer '%s' not found", customer));
        } else {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));

            return new Customer(customer.getFullName(), authorities, "ROLE_CUSTOMER");
        }
    }
}
