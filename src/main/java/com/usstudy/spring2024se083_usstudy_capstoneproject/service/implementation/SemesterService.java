package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.SemesterRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ISemesterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SemesterService implements ISemesterService {
    private final SemesterRepository semesterRepository;

    @Override
    public List<Semester> getAllSemester() {
        return semesterRepository.findAll();
    }

    @Override
    public Optional findSemesterById(int id) {
        return semesterRepository.findById(id);
    }
}
