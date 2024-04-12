package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramFeeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramFeeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramFeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramFeeServiceImpl implements ProgramFeeService {
    private final ProgramFeeRepository programFeeRepository;

    @Override
    public ProgramFeeDto saveProgramFee(ProgramFeeRequest programFeeRequest) {
        return ProgramFeeMapper.INSTANCE.toDto(
                programFeeRepository.save(
                        ProgramFeeMapper.INSTANCE.toEntity(programFeeRequest)
                )
        );
    }

    @Override
    public List<ProgramFeeDto> getAll() {
        return programFeeRepository.findAll()
                .stream().map(ProgramFeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProgramFeeDto> findById(Integer id) {
        return programFeeRepository.findById(id)
                .map(ProgramFeeMapper.INSTANCE::toDto);
    }

    @Override
    public List<ProgramFeeDto> findByProgramId(Integer programId) {
        return programFeeRepository.getByProgramId(programId)
                .stream().map(ProgramFeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
