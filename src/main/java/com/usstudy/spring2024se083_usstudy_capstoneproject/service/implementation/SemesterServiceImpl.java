package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SemesterDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.SemesterMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.SemesterRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ISemesterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SemesterServiceImpl implements ISemesterService {
    private final SemesterRepository semesterRepository;
    private final SemesterMapper semesterMapper;

    @Override
    public List<SemesterDto> getAllSemester() {
        return semesterRepository.findAll()
                .stream().map(semesterMapper::semesterToSemesterDto).collect(Collectors.toList());
    }

    @Override
    public Optional findSemesterById(int id) {
        return semesterRepository.findById(id)
                .map(semesterMapper::semesterToSemesterDto);
    }
}
