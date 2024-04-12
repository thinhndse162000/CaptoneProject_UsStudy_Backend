package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramFeeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramFee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramFeeMapper {
    ProgramFeeMapper INSTANCE= Mappers.getMapper(ProgramFeeMapper.class);
    @Mapping(target = "programId",source = "programFee.program.programId")
    @Mapping(target = "feeTypeId",source = "programFee.feeType.feeTypeId")
    ProgramFeeDto toDto(ProgramFee programFee);
    @Mapping(target = "program",source = "programId", qualifiedByName = "MapProgram")
    @Mapping(target = "feeType",source = "feeTypeId", qualifiedByName = "MapFeeType")
    ProgramFee toEntity(ProgramFeeRequest programFeeRequest);
    @Named("MapProgram")
    default Program mapProgram(Integer id){
        Program program=new Program();
        program.setProgramId(id);
        return program;
    }
    @Named("MapFeeType")
    default FeeType mapFeeType(Integer id){
        FeeType feeType=new FeeType();
        feeType.setFeeTypeId(id);
        return feeType;
    }
}
