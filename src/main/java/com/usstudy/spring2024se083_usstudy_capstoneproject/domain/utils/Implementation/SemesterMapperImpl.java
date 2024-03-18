package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SemesterDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.SemesterMapper;
import org.springframework.stereotype.Component;

@Component
public class SemesterMapperImpl implements SemesterMapper {
    @Override
    public SemesterDto semesterToSemesterDto(Semester semester) {
        if (semester==null)
            return null;
        SemesterDto semesterDto =new SemesterDto();
        semesterDto.setSemesterId(semester.getSemesterId());
        semesterDto.setStartDate(semester.getStartDate());
        semesterDto.setEndDate(semester.getEndDate());
        return semesterDto;
    }
}
