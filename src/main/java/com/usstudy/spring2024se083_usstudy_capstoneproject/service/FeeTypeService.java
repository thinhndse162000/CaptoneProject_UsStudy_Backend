package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;

import java.util.List;
import java.util.Optional;

public interface FeeTypeService {
    List<FeeType> getAllFeeType();
    Optional<?> getById(int id);
    FeeType saveFeeType(FeeType feeType);
}
