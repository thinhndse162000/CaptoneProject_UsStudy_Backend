package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.DocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentDto;

import java.util.List;

public interface DocumentService {
    List<DocumentDto> getAll();
    DocumentDto getById(Integer id);
    DocumentDto saveDocument(DocumentRequest documentRequest,Integer id);
    List<DocumentDto> getByProgramApplicationId(Integer id);
}
