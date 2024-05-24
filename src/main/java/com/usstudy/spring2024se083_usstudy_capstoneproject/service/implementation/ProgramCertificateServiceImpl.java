package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramCertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramCertificateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramCertificate;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramCertificateMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramCertificateRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramCertificateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramCertificateServiceImpl implements ProgramCertificateService {
    private final ProgramCertificateRepository repository;

    public ProgramCertificateServiceImpl(ProgramCertificateRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProgramCertificateDto createProgramCertificate(ProgramCertificateRequest request) {
        return ProgramCertificateMapper
                .INSTANCE
                .toDto(repository.save(ProgramCertificateMapper.INSTANCE.toEntity(request)));
    }

    @Override
    public ProgramCertificateDto updateProgramCertificate(ProgramCertificateRequest request, Integer id) {
        ProgramCertificate programCertificate = repository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Program certificate id - " + id));
        MergeRequest.mergeIgnoreNullValue(request, programCertificate);
        return ProgramCertificateMapper
                .INSTANCE
                .toDto(repository.save(programCertificate));
    }

    @Override
    public List<ProgramCertificateDto> getAll() {
        return repository.findAll()
                .stream()
                .map(ProgramCertificateMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramCertificateDto getById(Integer id) {
        return ProgramCertificateMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<ProgramCertificateDto> getByProgramId(Integer id) {
        return repository.getAllByProgramProgramId(id)
                .stream().map(ProgramCertificateMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
