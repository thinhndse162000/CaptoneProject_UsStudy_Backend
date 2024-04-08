package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentProfileMapper {
    StudentProfileMapper INSTANCE= Mappers.getMapper(StudentProfileMapper.class);
    @Mapping(target = "customerId",source = "studentProfile.customer.customerId")
    StudentProfileDto toDto(StudentProfile studentProfile);
    @Mapping(target = "customer",source = "customerId",qualifiedByName = "MapCustomer")
    StudentProfile toEntity(StudentProfileDto studentProfileDto);
    @Named("MapCustomer")
    default Customer mapCustomer(Integer id){
        Customer customer=new Customer();
        customer.setCustomerId(id);
        return customer;
    }
}
