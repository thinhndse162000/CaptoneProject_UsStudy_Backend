package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.SemesterRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.ISemesterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SemesterService implements ISemesterService {
    private final SemesterRepository semesterRepository;

}
