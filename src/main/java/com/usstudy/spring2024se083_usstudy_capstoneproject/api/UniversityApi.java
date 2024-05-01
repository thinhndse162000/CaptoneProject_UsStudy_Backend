package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/universities")
@RequiredArgsConstructor
@Tag(name = "University-API")
//@SecurityRequirement(name = "Authorization")
public class UniversityApi {
    private final IUniversityService universityService;

    //@Secured("ROLE_CUSTOMER")
    @Operation(summary = "Get a list of Universities with filter", description = "Return a list of Universities")
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) Float tuition,
                                    @RequestParam(required = false) String description) {
        if (name!=null||tuition!=null||description!=null){
            UniversityFilterRequest request=new UniversityFilterRequest(name,tuition,description);
            return ResponseEntity.ok(universityService.getUniversityByRequest(request));
        }
        List<UniversityDto> result = universityService.getAllUniversity();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Get an University by university id", description = "Return a University")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByUniversityId(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }

    @Operation(summary = "Create an University ", description = "Create University ")
    @PostMapping("")
    public ResponseEntity<?> postUniversity(@RequestBody UniversityRequest universityRequest) {
        try {
            UniversityDto result = universityService.saveUniversity(universityRequest,null);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @Operation(summary = "Get a list of Universities by university type"
            , description = "Return a list Universities by university type")
    @GetMapping("/type")
    public ResponseEntity<?> getUniversityByType(@RequestParam Integer typeId) {
        return ResponseEntity.ok(universityService.getUniversityByTypeId(typeId));
    }
    @Operation(summary = "Get a list of Universities by state"
            , description = "Return a list Universities by state")
    @GetMapping("/state")
    public ResponseEntity<?> getUniversityByState(@RequestParam Integer stateId) {
        return ResponseEntity.ok(universityService.getUniversityByStateId(stateId));
    }

    @Operation(summary = "Update an University ", description = "Update University ")
    @PutMapping("/{id}")
    public ResponseEntity<?> putUniversity(@PathVariable Integer id,
                                           @RequestBody UniversityRequest universityRequest) {

        UniversityDto result = universityService.saveUniversity(universityRequest,id);
        return ResponseEntity.ok(result);
    }

//    @PostMapping("/filter")
//    public ResponseEntity<List<UniversityDto>> getUniversityByRequest(@RequestBody UniversityFilterRequest request) {
//        return ResponseEntity.ok(universityService.getUniversityByRequest(request));
//    }
}
