package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramTypeMapper;
import org.springframework.stereotype.Component;


public class ProgramTypeMapperImpl implements ProgramTypeMapper {
    @Override
    public ProgramTypeDto programTypeToProgramTypeDto(ProgramType programType) {
        if (programType==null)
            return null;
        ProgramTypeDto programTypeDto=new ProgramTypeDto();
        programTypeDto.setProgramTypeId(programType.getProgramTypeId());
        programTypeDto.setTypeName(programType.getTypeName());
        programTypeDto.setDescription(programType.getDescription());
        return programTypeDto;
    }
}
