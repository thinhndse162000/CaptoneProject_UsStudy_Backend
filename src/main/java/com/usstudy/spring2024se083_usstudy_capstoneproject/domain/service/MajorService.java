package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.MajorRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IMajorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MajorService implements IMajorService {
    private final MajorRepository majorRepository;
}
