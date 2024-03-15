package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.CustomerMapper;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;


@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-03-24T20:50:35+0700",
        comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setFullName(customer.getFullName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        customerDto.setGender(customer.getGender());
        customerDto.setPassword(customer.getPassword());
        customerDto.setPhone(customer.getPhone());
        customerDto.setCustomerId(customerDto.getCustomerId());
        return customerDto;
    }
}
