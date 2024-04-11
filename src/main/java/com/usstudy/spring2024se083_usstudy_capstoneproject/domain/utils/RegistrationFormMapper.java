package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.RegistrationFormDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationFormMapper {
    RegistrationFormMapper INSTANCE= Mappers.getMapper(RegistrationFormMapper.class);
    @Mapping(target = "customerId",source = "registrationForm.customer.customerId")
    @Mapping(target = "consultantId",source = "registrationForm.consultant.consultantId")
    RegistrationFormDto toDto(RegistrationForm registrationForm);
    @Mapping(target = "customer",source = "customerId", qualifiedByName = "MapCustomer")
    @Mapping(target = "consultant",source = "consultantId", qualifiedByName = "MapConsultant")
    RegistrationForm toEntity(RegistrationFormDto registrationFormDto);
    @Named("MapCustomer")
    default Customer mapCustomer(Integer id){
        Customer customer=new Customer();
        customer.setCustomerId(id);
        return customer;
    }
    @Named("MapConsultant")
    default Consultant mapConsultant(Integer id){
        Consultant consultant=new Consultant();
        consultant.setConsultantId(id);
        return consultant;
    }
}
