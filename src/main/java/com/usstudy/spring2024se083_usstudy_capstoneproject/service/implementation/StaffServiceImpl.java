package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StaffDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StaffMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StaffRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StaffService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    @Override
    public List<StaffDto> getAllStaff() {
        return staffRepository.findAll()
                .stream().map(StaffMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto getStaffById(Integer id) {
        return staffRepository.findById(id)
                .map(StaffMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NullPointerException("Staff not found - "+id));
    }
}
