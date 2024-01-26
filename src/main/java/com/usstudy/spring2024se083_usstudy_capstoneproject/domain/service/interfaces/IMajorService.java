package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMajorService {
    List<Major> getAllMajor();
}
