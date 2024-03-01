package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IStateService;
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

<<<<<<< Updated upstream
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
=======
    @Operation(summary = "Get all State", description = "Returns all States")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<State> result = stateService.getAllState();
        return ResponseEntity.ok(result);
    }
    @Operation(summary = "Get a State by id", description = "Return a State")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(stateService.getStateById(id));
>>>>>>> Stashed changes
    }
}
