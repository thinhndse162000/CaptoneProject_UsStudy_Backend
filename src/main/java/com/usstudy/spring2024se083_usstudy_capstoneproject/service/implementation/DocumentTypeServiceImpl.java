package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.DocumentTypeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.DocumentTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.DocumentTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeRepository documentTypeRepository;
    @Override
    public List<DocumentTypeDto> getAll() {
        return documentTypeRepository.findAll()
                .stream().map(DocumentTypeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
