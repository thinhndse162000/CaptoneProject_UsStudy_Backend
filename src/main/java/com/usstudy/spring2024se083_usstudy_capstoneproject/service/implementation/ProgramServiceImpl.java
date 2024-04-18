package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    public ProgramDto saveProgram(ProgramRequest programRequest,Integer id) {
        //update program
        if (id!=null){

            Program previousProgram=programRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("Program not found - " + id));;
            previousProgram.setNameProgram(programRequest.getNameProgram());
            previousProgram.setModifiedDate(new Date(System.currentTimeMillis()));
            previousProgram.setStatus(programRequest.getStatus());
            previousProgram.setCreateDate(programRequest.getCreateDate());
            previousProgram.setModifier(programRequest.getModifier());
            previousProgram.setDuration(programRequest.getDuration());
            previousProgram.setDescription(programRequest.getDescription());
            previousProgram.setTuition(programRequest.getTuition());
            previousProgram.setLevel(programRequest.getLevel());
            previousProgram.setImg(programRequest.getImg());
            previousProgram.setRequirement(programRequest.getRequirement());
            previousProgram.setResponsibilities(programRequest.getResponsibilities());
            return ProgramMapper.INSTANCE.programToProgramDto(
                    programRepository.save(previousProgram));
        }
        //create new program
        return ProgramMapper.INSTANCE.programToProgramDto(
                programRepository.save(ProgramMapper.INSTANCE.toEntity(programRequest)));
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

    @Override
    public List<ProgramDto> getProgrambyRequest(ProgramFilterRequest request) {
        List<Program> programs = programRepository.getProgramByRequest(request);
        return programs
                .stream()
                .map(ProgramDto::convert).collect(Collectors.toList());
    }

    @Override
    public List<ProgramDto> getProgramList(Integer universityId) {
        List<Program> program = programRepository.getProgrambyUniversityId(universityId);
        return program.stream().map(ProgramDto::convert).collect(Collectors.toList());
    }
}
