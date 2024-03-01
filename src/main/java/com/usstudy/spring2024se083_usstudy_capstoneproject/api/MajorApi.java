package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IMajorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majors")
@RequiredArgsConstructor
@Tag(name = "Major-API")
public class MajorApi {

    private final IMajorService majorService;
    @GetMapping("")
    public ResponseEntity<?> getAll()
    {
        List<Major> result=majorService.getAllMajor();
        return ResponseEntity.ok(result);
    }
<<<<<<< Updated upstream
=======
    @Operation(summary = "Get a Major by major id", description = "Returns All Major")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByMajorId(@PathVariable Integer id) {
        return ResponseEntity.ok(majorService.findById(id));
    }

    @Operation(summary = "Create New Major", description = "Create a new Major")
>>>>>>> Stashed changes
    @PostMapping("")
    public ResponseEntity<?> postMajor(@RequestBody Major major){
        try {
            Major result= majorService.saveMajor(major);
            return  ResponseEntity.ok(result);
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @PutMapping("")
    public ResponseEntity<?> putMajor(@RequestBody Major major){
        try {
            if (major.getMajorId()!=null && !majorService.findById(major.getMajorId()).isEmpty())
            {
                Major result= majorService.saveMajor(major);
                return  ResponseEntity.ok(result);
            }
            else {
                return ResponseEntity.badRequest().body("No major with id "+major.getMajorId()+" found!");
            }
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
