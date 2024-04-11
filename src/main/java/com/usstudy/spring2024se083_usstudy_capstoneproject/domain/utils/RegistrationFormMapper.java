package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.RegistrationFormDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationFormMapper {

    RegistrationFormMapper INSTANCE = Mappers.getMapper(RegistrationFormMapper.class);

    @Mapping(target = "customerId", source = "registrationForm.customer.customerId")
    @Mapping(target = "consultantId", source = "registrationForm.consultant.consultantId")
    RegistrationFormDto reigstrationFormToRegistrationFormDto(RegistrationForm registrationForm);
}
