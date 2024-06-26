package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramDocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDocumentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramDocumentMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramDocumentRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramDocumentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramDocumentServiceImpl implements ProgramDocumentService {
    private final ProgramDocumentRepository programDocumentRepository;
    @Override
    public List<ProgramDocumentDto> getAll() {
        return programDocumentRepository.findAll()
                .stream().map(ProgramDocumentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramDocumentDto getById(Integer id) {
        return ProgramDocumentMapper.INSTANCE.toDto(
                programDocumentRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No Program Document id - "+id))
        );
    }

    @Override
    public List<ProgramDocumentDto> getByProgramId(Integer id) {
        return programDocumentRepository.getAllByProgramProgramId(id)
                .stream().map(ProgramDocumentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramDocumentDto> saveListProgramDocument(List<ProgramDocumentRequest> programDocumentRequests) {
        List<ProgramDocumentDto> result=new ArrayList<>();
        for (ProgramDocumentRequest request:programDocumentRequests){
            result.add(
                    ProgramDocumentMapper.INSTANCE.toDto(
                            programDocumentRepository.save(ProgramDocumentMapper.INSTANCE.toEntity(request))
                    )
            );
        }
        return result;
    }
}
