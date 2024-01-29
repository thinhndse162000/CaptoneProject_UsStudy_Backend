package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;

import java.util.List;
import java.util.Optional;

public interface IStateService {
    List<State> getAllState();
    Optional getStateById(int id);
}
