package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;

import java.util.List;

public interface CertificateTypeService {
    List<CertificateTypeDto> getAll();
}
