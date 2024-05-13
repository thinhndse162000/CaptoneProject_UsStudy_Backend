package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.SubjectMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.SubjectRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.SubjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    @Override
    public List<SubjectDto> getAll() {
        return subjectRepository.findAll().stream().map(SubjectMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto getById(Integer id) {
        return SubjectMapper.INSTANCE.toDto(
                subjectRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No Subject id - "+id))
        );
    }
}
