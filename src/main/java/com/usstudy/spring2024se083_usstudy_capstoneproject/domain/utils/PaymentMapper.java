package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Payment;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE= Mappers.getMapper(PaymentMapper.class);
    @Mapping(target = "programApplicationId",source = "payment.programApplication.programApplicationId")
    PaymentDto toDto(Payment payment);
    @Mapping(target = "programApplication",source = "programApplicationId",qualifiedByName = "MapProgramApplication")
    Payment toEntity(PaymentRequest paymentRequest);
    @Named("MapProgramApplication")
    default ProgramApplication mapProgramApplication(Integer id){
        ProgramApplication programApplication=new ProgramApplication();
        programApplication.setProgramApplicationId(id);
        return programApplication;
    }
}
