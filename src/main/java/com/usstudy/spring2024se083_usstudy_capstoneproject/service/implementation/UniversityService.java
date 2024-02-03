package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.UniversityRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityService implements IUniversityService {
    private final UniversityRepository universityRepository;

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    @Override
    public Optional getUniversityById(int id) {
        return universityRepository.findById(id);
    }

    @Override
    public University saveUniversity(University university) {
        universityRepository.save(university);
        return university;
    }
}
