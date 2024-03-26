package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.MajorMapper;
import org.springframework.stereotype.Component;


public class MajorMapperImpl implements MajorMapper {

    @Override
    public MajorDto majorToMajorDto(Major major) {
        if (major==null)
            return null;
        MajorDto majorDto =new MajorDto();
        majorDto.setMajorId(major.getMajorId());
        majorDto.setMajorName(major.getMajorName());
        majorDto.setDescription(major.getDescription());
        majorDto.setImg(major.getImg());
        return majorDto;
    }
}
