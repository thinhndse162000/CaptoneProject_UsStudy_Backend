package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;

import java.util.List;
import java.util.Optional;

public interface IProgramTypeService {
    List<ProgramType> getAllProgramType();
    Optional getProgramTypeById(int id);
}
