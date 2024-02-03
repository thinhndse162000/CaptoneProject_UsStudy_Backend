package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.MajorRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IMajorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MajorService implements IMajorService {
    private final MajorRepository majorRepository;

    @Override
    public List<Major> getAllMajor() {
        return majorRepository.findAllByOrderByMajorIdDesc();
    }

    @Override
    public Major saveMajor(Major major) {
        majorRepository.save(major);
        return major;
    }

    @Override
    public Optional<?> findById(int id) {
        return  majorRepository.findById(id);
    }
}
