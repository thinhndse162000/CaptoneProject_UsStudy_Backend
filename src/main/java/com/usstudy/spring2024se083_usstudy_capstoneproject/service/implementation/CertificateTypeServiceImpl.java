package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.CertificateTypeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CertificateTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CertificateTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CertificateTypeServiceImpl implements CertificateTypeService {
    private final CertificateTypeRepository certificateTypeRepository;
    @Override
    public List<CertificateTypeDto> getAll() {
        return certificateTypeRepository.findAll()
                .stream().map(CertificateTypeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
