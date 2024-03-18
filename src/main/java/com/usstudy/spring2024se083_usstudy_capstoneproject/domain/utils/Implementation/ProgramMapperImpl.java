package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramMapper;
import org.springframework.stereotype.Component;

@Component
public class ProgramMapperImpl implements ProgramMapper {
    @Override
    public ProgramDto programToProgramDto(Program program) {
        if (program==null)
            return null;
        ProgramDto programDto =new ProgramDto();
        programDto.setProgramId(program.getProgramId());
        programDto.setNameProgram(program.getNameProgram());
        programDto.setDescription(program.getDescription());
        programDto.setProgramTypeId(program.getProgramTypeId());
        programDto.setDuration(program.getDuration());
        programDto.setLevel(program.getLevel());
        programDto.setModifier(program.getModifier());
        programDto.setStatus(program.getStatus());
        programDto.setCreateDate(program.getCreateDate());
        programDto.setModifiedDate(program.getModifiedDate());
        programDto.setMajorId(program.getMajorId());
        programDto.setSemesterId(program.getSemesterId());
        programDto.setUniversityId(program.getUniversityId());
        programDto.setTuition(program.getTuition());
        return programDto;
    }
}
