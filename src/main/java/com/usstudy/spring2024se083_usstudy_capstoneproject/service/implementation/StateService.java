package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StateRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IStateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StateService implements IStateService {
    private final StateRepository stateRepository;

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public Optional getStateById(int id) {
        return stateRepository.findById(id);
    }
}
