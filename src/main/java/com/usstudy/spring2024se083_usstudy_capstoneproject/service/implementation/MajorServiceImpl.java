package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.MajorMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.MajorRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IMajorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MajorServiceImpl implements IMajorService {
    private final MajorRepository majorRepository;
    private final MajorMapper majorMapper;

    @Override
    public List<MajorDto> getAllMajor() {
        return majorRepository.findAllByOrderByMajorIdDesc()
                .stream().map(majorMapper::majorToMajorDto).collect(Collectors.toList());
    }

    @Override
    public MajorDto saveMajor(Major major) {
        majorRepository.save(major);
        return majorMapper.majorToMajorDto(major);
    }

    @Override
    public Optional<?> findById(int id) {
        return  majorRepository.findById(id)
                .map(majorMapper::majorToMajorDto);
    }
}
