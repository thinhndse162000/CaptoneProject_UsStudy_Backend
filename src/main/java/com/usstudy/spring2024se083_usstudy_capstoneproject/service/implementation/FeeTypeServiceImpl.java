package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FeeTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.FeeTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeeTypeServiceImpl implements FeeTypeService {
    private final FeeTypeRepository feeTypeRepository;
    @Override
    public List<FeeType> getAllFeeType() {
        return feeTypeRepository.findAll();
    }

    @Override
    public Optional<?> getById(int id) {
        return feeTypeRepository.findById(id);
    }

    @Override
    public FeeType saveFeeType(FeeType feeType) {
        feeTypeRepository.save(feeType);
        return feeType;
    }
}
