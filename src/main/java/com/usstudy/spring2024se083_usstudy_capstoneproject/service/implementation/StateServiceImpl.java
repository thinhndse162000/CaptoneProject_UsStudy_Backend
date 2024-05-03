package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StateMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StateRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IStateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StateServiceImpl implements IStateService {
    private final StateRepository stateRepository;

    @Override
    public List<StateDto> getAllState() {
        return stateRepository.findAll().stream().map(StateMapper.INSTANCE::stateToStateDto).collect(Collectors.toList());
    }

    @Override
    public Optional getStateById(int id) {
        return stateRepository.findById(id).map(StateMapper.INSTANCE::stateToStateDto);
    }
}
