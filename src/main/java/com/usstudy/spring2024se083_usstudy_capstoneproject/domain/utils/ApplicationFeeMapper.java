package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplicationFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplicationFeeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplicationFee;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramFee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationFeeMapper {
    ApplicationFeeMapper INSTANCE= Mappers.getMapper(ApplicationFeeMapper.class);
    @Mapping(target = "programFeeId",source = "applicationFee.programFee.programFeeId")
    @Mapping(target = "programApplicationId",source = "applicationFee.programApplication.programApplicationId")
    //@Mapping(target = "total",source = "applicationFee.total")
    ApplicationFeeDto toDto(ApplicationFee applicationFee);
    @Mapping(target = "programFee",source = "programFeeId", qualifiedByName = "MapProgramFee")
    @Mapping(target = "programApplication",source = "programApplicationId",qualifiedByName = "MapProgramApplication")
    ApplicationFee toEntity(ApplicationFeeRequest applicationFeeRequest);
    @Named("MapProgramFee")
    default ProgramFee mapProgramFee(Integer id){
        ProgramFee programFee=new ProgramFee();
        programFee.setProgramFeeId(id);
        return programFee;
    }
    @Named("MapProgramApplication")
    default ProgramApplication mapProgramApplication(Integer id){
        ProgramApplication programApplication=new ProgramApplication();
        programApplication.setProgramApplicationId(id);
        return programApplication;
    }
}
