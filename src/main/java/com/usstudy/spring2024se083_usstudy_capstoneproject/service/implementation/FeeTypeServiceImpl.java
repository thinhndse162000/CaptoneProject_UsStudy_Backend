package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.FeeTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.FeeTypeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FeeTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.FeeTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeeTypeServiceImpl implements FeeTypeService {
    private final FeeTypeRepository feeTypeRepository;
    @Override
    public List<FeeTypeDto> getAllFeeType() {
        return feeTypeRepository.findAll()
                .stream().map(FeeTypeMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<?> getById(int id) {
        return feeTypeRepository.findById(id).map(FeeTypeMapper.INSTANCE::toDto);
    }

    @Override
    public FeeTypeDto saveFeeType(FeeTypeDto feeTypeDto) {
        return FeeTypeMapper.INSTANCE.toDto(
                feeTypeRepository.save(FeeTypeMapper.INSTANCE.toEntity(feeTypeDto)));
    }
}
