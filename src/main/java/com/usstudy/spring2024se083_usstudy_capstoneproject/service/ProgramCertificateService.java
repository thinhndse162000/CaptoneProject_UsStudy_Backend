package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramCertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramCertificateDto;

import java.util.List;

public interface ProgramCertificateService {

    ProgramCertificateDto createProgramCertificate(ProgramCertificateRequest request);
    List<ProgramCertificateDto> saveListProgramCertificate(List<ProgramCertificateRequest> certificateRequests);

    ProgramCertificateDto updateProgramCertificate(ProgramCertificateRequest request, Integer id);

    List<ProgramCertificateDto> getAll();

    ProgramCertificateDto getById(Integer id);
    List<ProgramCertificateDto> getByProgramId(Integer id);
}
