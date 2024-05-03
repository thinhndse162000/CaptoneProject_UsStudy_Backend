package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CustomerRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANT = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerRequest customerRequest);
}
