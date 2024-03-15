package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ConsultantMapper;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-03-24T20:50:35+0700",
        comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ConsultantMapperImpl implements ConsultantMapper {

    @Override
    public ConsultantDto consultantToConsultantDto(Consultant consultant) {
        if (consultant == null) {
            return null;
        }

        ConsultantDto consultantDto = new ConsultantDto();

        consultantDto.setConsultantId(consultant.getConsultantId());
        consultantDto.setDescription(consultant.getDescription());
        consultantDto.setEmail(consultant.getEmail());
        consultantDto.setUserName(consultant.getUsername());
        consultantDto.setPassword(consultant.getPassword());
        return consultantDto;
    }
}
