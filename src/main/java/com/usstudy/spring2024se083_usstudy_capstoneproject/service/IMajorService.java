package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.MajorRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMajorService {
    List<MajorDto> getAllMajor();
    MajorDto saveMajor(MajorRequest majorRequest,Integer id);
    Optional findById(int id);
}
