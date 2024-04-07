package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.FeeTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;

import java.util.List;
import java.util.Optional;

public interface FeeTypeService {
    List<FeeTypeDto> getAllFeeType();
    Optional<?> getById(int id);
    FeeTypeDto saveFeeType(FeeTypeDto feeTypeDto);
}
