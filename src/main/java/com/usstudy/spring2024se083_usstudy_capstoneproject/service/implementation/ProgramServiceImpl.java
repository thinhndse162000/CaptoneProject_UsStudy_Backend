package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramServiceImpl implements IProgramService {
    private final ProgramRepository programRepository;
    //private final ProgramMapper programMapper;

    @Override
    public Iterable<ProgramDto> getAllProgram() {
        return programRepository.findAll()
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional getProgramById(int id) {
        return programRepository.findById(id)
                .map(ProgramMapper.INSTANCE::programToProgramDto);
    }

    @Override
    public ProgramDto saveProgram(ProgramDto programDto) {
        return ProgramMapper.INSTANCE.programToProgramDto(
                programRepository.save(ProgramMapper.INSTANCE.programDtoToProgram(programDto)));
    }

    @Override
    public List<ProgramDto> getProgramsByUniversityId(int id) {
        return programRepository.getProgramsByUniversityUniversityId(id)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramsByMajorId(int id) {
        return programRepository.getProgramsByMajorMajorId(id)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramsByUniversityIdAndMajorId(int universityId, int majorId) {
        return programRepository.getProgramsByUniversityUniversityIdAndMajorMajorId(universityId, majorId)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramsByProgramName(String programName) {
        return programRepository.getProgramsByNameProgramContains(programName)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramsByProgramTypeId(Integer programTypeId) {
        return programRepository.getProgramByProgramTypeId(programTypeId)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramsBySemesterId(Integer semesterId) {
        return programRepository.getProgramBySemesterId(semesterId)
                .stream().map(ProgramMapper.INSTANCE::programToProgramDto)
                .collect(Collectors.toList());
    }
}
