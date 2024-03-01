package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
@Tag(name = "Program-API")
public class ProgramApi {
    private final IProgramService programService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer programId,
                                    @RequestParam(required = false) Integer universityId)
    {
        if (programId!=null)
        {
            return ResponseEntity.ok(programService.getProgramById(programId));
        }
        if (universityId!=null){
            return ResponseEntity.ok(programService.getProgramsByUniversityId(universityId));
        }
        else {
            List<Program> result=programService.getAllProgram();
            return ResponseEntity.ok(result);
        }
    }
    @PostMapping("")
    public ResponseEntity<?> postProgram(@RequestBody Program program,
                                         @RequestParam(required = false,defaultValue ="false") Boolean useServerTime){
        try {
            if (useServerTime==true){
                program.setCreateDate(LocalDate.now());
            }
            Program result= programService.saveProgram(program);
            return  ResponseEntity.ok(result);
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @PutMapping("")
    public ResponseEntity<?> putProgram(@RequestBody Program program,
                                        @RequestParam(required = false,defaultValue ="false") Boolean useServerTime){
        try {
            if (program.getProgramId()!=null && !programService.getProgramById(program.getProgramId()).isEmpty())
            {
                if (useServerTime==true){
                    program.setModifiedDate(LocalDate.now());
                }
                Program result= programService.saveProgram(program);
                return  ResponseEntity.ok(result);
            }
            else {
                return ResponseEntity.badRequest().body("No major with id "+program.getProgramId()+" found!");
            }
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
