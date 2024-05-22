package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateDto;

import java.util.List;

public interface CertificateService {
    List<CertificateDto> getAll();
    CertificateDto getById(Integer id);
    CertificateDto saveCertificate(CertificateRequest certificateRequest,Integer id);
    List<CertificateDto> saveListCertificate(List<CertificateRequest> certificateRequests);
}
