package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentTypeDto;

import java.util.List;

public interface DocumentTypeService {
    List<DocumentTypeDto> getAll();
}
