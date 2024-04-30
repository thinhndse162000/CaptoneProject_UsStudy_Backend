package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplicationFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplicationFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/application-fees")
@RequiredArgsConstructor
@Tag(name = "Application-Fee-API")
public class ApplicationFeeApi {
    private final ApplicationFeeService applicationFeeService;

    @Operation(summary = "Get an Application Fee by id", description = "Returns a Application Fee by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(applicationFeeService.findById(id));
    }
    @Operation(summary = "Get a list of Application Fees", description = "Returns a list of Application Fee")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(applicationFeeService.getAll());
    }
    @Operation(summary = "Create an Application Fee (if programId is not null, add sum program fee to amount)",
            description = "Returns an Application Fee, or null if no such Program Fee exist" +
                    ", or error if FK not exist in database")
    @PostMapping("")
    public ResponseEntity<?> postApplicationFee(@RequestBody ApplicationFeeRequest applicationFeeRequest,
                                                @RequestParam(required = false) Integer programId){
        return ResponseEntity.ok(applicationFeeService.saveApplicationFee(applicationFeeRequest,programId));
    }
    @Operation(summary = "Update an Application Fee",
            description = "Returns an Application Fee, or null if no such Program Fee exist"+
                    ", or error if FK not exist in database")
    @PutMapping("/{id}")
    public ResponseEntity<?> putApplicationFee(@PathVariable Integer id,
                                               @RequestBody ApplicationFeeRequest applicationFeeRequest){
//        if (id==null)
//            return ResponseEntity.badRequest().body("Id cannot be empty");
//        applicationFeeRequest.setApplicationFeeId(id);
        return ResponseEntity.ok(applicationFeeService.updateApplicationFee(applicationFeeRequest,id));
    }
}
