package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.MajorRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IMajorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MajorService implements IMajorService {
    private final MajorRepository majorRepository;

    @Override
    public List<Major> getAllMajor() {
        return majorRepository.findAllByOrderByMajorIdDesc();
    }
}
