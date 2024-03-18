package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.Implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StateMapper;
import org.springframework.stereotype.Component;

@Component
public class StateMapperImpl implements StateMapper {
    @Override
    public StateDto stateToStateDto(State state) {
        if (state==null){
            return null;
        }
        StateDto stateDto=new StateDto();
        stateDto.setStateId(state.getStateId());
        stateDto.setStateName(state.getStateName());
        stateDto.setDescription(state.getDescription());
        return stateDto;
    }
}
