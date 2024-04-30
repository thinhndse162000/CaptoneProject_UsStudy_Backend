package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplicationFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplicationFeeDto;

import java.util.List;
import java.util.Optional;

public interface ApplicationFeeService {
    ApplicationFeeDto saveApplicationFee(ApplicationFeeRequest applicationFeeRequest,Integer programId);
    ApplicationFeeDto updateApplicationFee(ApplicationFeeRequest applicationFeeRequest,Integer id);
    Optional findById(Integer id);
    List<ApplicationFeeDto> getAll();

}
