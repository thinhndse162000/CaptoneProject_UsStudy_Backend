package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;

import java.util.List;

public interface ConsultantService {

    Consultant getConsultantByEmail(String email);

    List<ConsultantDto> getAllConsultant();
}
