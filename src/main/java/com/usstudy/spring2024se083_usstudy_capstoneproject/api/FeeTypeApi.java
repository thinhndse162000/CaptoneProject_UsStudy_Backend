package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.FeeTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/fee-types")
@RequiredArgsConstructor
@Tag(name = "FeeType-API")
public class FeeTypeApi {
    private final FeeTypeService feeTypeService;
    @Operation(summary = "Get a list Fee Type", description = "Return a list of Fee Type")
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(feeTypeService.getAllFeeType());
    }
    @Operation(summary = "Get a Fee Type by id", description = "Return a Fee Type")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByFeeTypeId(@PathVariable Integer id) {
        return ResponseEntity.ok(feeTypeService.getById(id));
    }
    @Operation(summary = "Create new Fee Type", description = "Create new Fee Type")
    @PostMapping("")
    public  ResponseEntity<?> createFeeType(@RequestBody FeeType feeType){
        try {
            FeeType result=feeTypeService.saveFeeType(feeType);
            return ResponseEntity.ok(result);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @Operation(summary = "Update a Fee Type", description = "Update a Fee Type ")
    @PutMapping("")
    public  ResponseEntity<?> updateFeeType(@RequestBody FeeType feeType){
        try {
            if(feeType.getFeeTypeId()!=null && !feeTypeService.getById(feeType.getFeeTypeId()).isEmpty())
            {
                FeeType result=feeTypeService.saveFeeType(feeType);
                return ResponseEntity.ok(result);
            }
            return ResponseEntity.badRequest().body("No fee type with id " + feeType.getFeeTypeId() + " found!");
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
