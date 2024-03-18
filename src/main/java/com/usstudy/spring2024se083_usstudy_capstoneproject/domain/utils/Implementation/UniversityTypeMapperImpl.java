package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.UniversityTypeMapper;
import org.springframework.stereotype.Component;

@Component
public class UniversityTypeMapperImpl implements UniversityTypeMapper {
    @Override
    public UniversityTypeDto universityTypeToUniversityTypeDto(UniversityType universityType) {
        if (universityType==null)
            return null;
        UniversityTypeDto universityTypeDto=new UniversityTypeDto();
        universityTypeDto.setUniversityTypeId(universityType.getUniversityTypeId());
        universityTypeDto.setTypeName(universityType.getTypeName());
        universityTypeDto.setDescription(universityType.getDescription());
        return universityTypeDto;
    }
}
