package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Certificate;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.CertificateMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CertificateRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CertificateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;
    @Override
    public List<CertificateDto> getAll() {
        return certificateRepository.findAll().stream().map(CertificateMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CertificateDto getById(Integer id) {
        return CertificateMapper.INSTANCE.toDto(
                certificateRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No certificate id - "+id))
        );
    }

    @Override
    public CertificateDto saveCertificate(CertificateRequest certificateRequest, Integer id) {
        if (id!=null){
            Certificate certificate=certificateRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("No certificate id - "+id));
            MergeRequest.mergeIgnoreNullValue(certificateRequest,certificate);
            return CertificateMapper.INSTANCE.toDto(
                    certificateRepository.save(certificate)
            );
        }
        return CertificateMapper.INSTANCE.toDto(
                certificateRepository.save(CertificateMapper.INSTANCE.toEntity(certificateRequest))
        );
    }
}
