package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IStateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
@Tag(name = "State-API")
public class StateApi {
    private final IStateService stateService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer stateId)
    {
        if (stateId!=null)
        {
            return ResponseEntity.ok(stateService.getStateById(stateId));
        }
        else {
            List<State> result=stateService.getAllState();
            return ResponseEntity.ok(result);
        }
    }
}
