package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplicationFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplicationFeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationFeeServiceImpl implements ApplicationFeeService {
    private final ApplicationFeeRepository applicationFeeRepository;
    private final ProgramFeeRepository programFeeRepository;
}
