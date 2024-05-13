package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SchoolProfileRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SchoolProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.SchoolProfileMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.SchoolProfileRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.SchoolProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SchoolProfileServiceImpl implements SchoolProfileService {
    private final SchoolProfileRepository schoolProfileRepository;
    @Override
    public List<SchoolProfileDto> getAll() {
        return schoolProfileRepository.findAll()
                .stream().map(SchoolProfileMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SchoolProfileDto getById(Integer id) {
        return SchoolProfileMapper.INSTANCE.toDto(
                schoolProfileRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("No School Profile id - "+id))
        );
    }

    @Override
    public SchoolProfileDto saveSchoolProfile(SchoolProfileRequest schoolProfileRequest) {
        SchoolProfile schoolProfile=SchoolProfileMapper.INSTANCE.toEntity(schoolProfileRequest);
        schoolProfile.setCreateDate(new Date(System.currentTimeMillis()));
        return SchoolProfileMapper.INSTANCE.toDto(
                schoolProfileRepository.save(schoolProfile)
        );
    }
}
