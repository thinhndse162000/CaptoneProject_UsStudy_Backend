package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.UniversityMapper;
import org.springframework.stereotype.Component;

@Component
public class UniversityMapperImpl implements UniversityMapper {
    @Override
    public UniversityDto universityToUniversityDto(University university) {
        if (university==null)
            return null;
        UniversityDto universityDto=new UniversityDto();
        universityDto.setUniversityId(university.getUniversityId());
        universityDto.setUniversityName(university.getUniversityName());
        universityDto.setDescription(university.getDescription());
        universityDto.setUniversityTypeId(university.getUniversityTypeId());
        universityDto.setImg(university.getImg());
        universityDto.setTuition(university.getTuition());
        universityDto.setStateId(university.getStateId());
        return universityDto;
    }
}

