package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramApplicationMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramApplicationRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramApplicationServiceImpl implements ProgramApplicationService {
    private final ProgramApplicationRepository programApplicationRepository;

    @Override
    public Optional getById(Integer id) {
        return programApplicationRepository.findById(id).map(ProgramApplicationMapper.INSTANCE::toDto);
    }

    @Override
    public List<ProgramApplicationDto> getAllFilter() {
        return programApplicationRepository.findAll()
                .stream().map(ProgramApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional getByStudentProfileId(Integer id) {
        return programApplicationRepository.findByStudentProfileStudentProfileId(id)
                .map(ProgramApplicationMapper.INSTANCE::toDto);
    }

    @Override
    public ProgramApplicationDto saveProgramApplication(ProgramApplicationDto programApplicationDto) {
        return ProgramApplicationMapper.INSTANCE.toDto(
                programApplicationRepository.save(ProgramApplicationMapper.INSTANCE.toEntity(programApplicationDto))
        );
    }
}
