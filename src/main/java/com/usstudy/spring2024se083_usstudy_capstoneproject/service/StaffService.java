package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StaffDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Staff;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAllStaff();
    StaffDto getStaffById(Integer id);
    Staff getStaffByEmail(String email);
}
