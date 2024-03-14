package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;

public interface ConsultantService {

    Consultant getConsultantByEmail(String email);
}
