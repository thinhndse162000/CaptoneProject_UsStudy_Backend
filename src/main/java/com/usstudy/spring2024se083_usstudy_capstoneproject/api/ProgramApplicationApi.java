package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/program-applications")
@RequiredArgsConstructor
@Tag(name = "Program-Application-API")
public class ProgramApplicationApi {
    private final ProgramApplicationService programApplicationService;

    @Operation(summary = "Get a Program Application by program application id", description = "Return a program application")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProgramApplicationId(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getById(id));
    }
    @Operation(summary = "Get a list of Program Application by staff id", description = "Return a list of program application")
    @GetMapping("/staff/{id}")
    public ResponseEntity<?> getByStaffId(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getByStaffId(id));
    }

    @Operation(summary = "Get a list of Program Application", description = "Return a list of program application")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programApplicationService.getAllFilter());
    }

    @Operation(summary = "Get a Program Application by student profile id", description = "Return a program application")
    @GetMapping("/student-profile/{id}")
    public ResponseEntity<?> getByStudentProfileId(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getByStudentProfileId(id));
    }

    @Operation(summary = "Create a Program Application",
            description = "Return a program application if success and create new apply stage in database," +
                    " return null if the program don't have any program stage")
    @PostMapping("")
    public ResponseEntity<?> postProgramApplication(@RequestBody ProgramApplicationRequest programApplicationRequest) {
        return ResponseEntity.ok(programApplicationService.saveProgramApplication(programApplicationRequest,null, null));
    }

    @Operation(summary = "Update an existed Program Application",
            description = "Return a program application if success and create new apply stage in database, " +
                    "return null if the program don't have any program stage " +
                    "or when stageNo bigger than that program list ProgramStage size")
    @PutMapping("/{id}")
    public ResponseEntity<?> putProgramApplication(@PathVariable Integer id,
                                                   @RequestParam Integer applyStageId,
                                                   @RequestBody ProgramApplicationRequest programApplicationRequest) {
//        programApplicationRequest.setProgramApplicationId(id);
//        if (!programApplicationService.getById(id).isEmpty()) {
//            return ResponseEntity.badRequest().body("No Program Application with id " + id + " found");
//        }
        return ResponseEntity.ok(programApplicationService.saveProgramApplication(programApplicationRequest,id, applyStageId));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<ProgramApplicationDto>> getProgramApplicationByCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getByCustomerId(id));
    }
}
