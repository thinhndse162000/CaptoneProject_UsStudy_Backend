package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ConsultantMapper;
import org.springframework.stereotype.Component;


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
