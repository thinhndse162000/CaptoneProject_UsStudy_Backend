package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;

import java.util.List;
import java.util.Optional;

public interface IStateService {
    List<StateDto> getAllState();
    Optional getStateById(int id);
}
