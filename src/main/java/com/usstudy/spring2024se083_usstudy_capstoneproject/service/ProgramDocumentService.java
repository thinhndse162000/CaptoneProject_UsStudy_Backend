package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramDocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDocumentDto;

import java.util.List;

public interface ProgramDocumentService {
    List<ProgramDocumentDto> getAll();
    ProgramDocumentDto getById(Integer id);
    List<ProgramDocumentDto> getByProgramId(Integer id);
    List<ProgramDocumentDto> saveListProgramDocument(List<ProgramDocumentRequest> programDocumentRequests);
}
