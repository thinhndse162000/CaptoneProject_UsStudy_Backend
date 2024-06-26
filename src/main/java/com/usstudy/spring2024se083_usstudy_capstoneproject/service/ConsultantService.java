package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;

import java.util.List;

public interface ConsultantService {

    Consultant getConsultantByEmail(String email);

    List<ConsultantDto> getAllConsultant();
    List<ConsultantDto> getConsultantFilter(ConsultantFilterRequest request);
    ConsultantDto getConsultantById(Integer consultantId);
    ConsultantDto saveConsultant(ConsultantRequest consultantRequest,Integer id);
}
