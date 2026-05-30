package com.apartmentmanagement.features.apartment.controller;

import com.apartmentmanagement.common.exception.ApiResponse;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingRequest;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingResponse;
import com.apartmentmanagement.features.apartment.domain.dto.PageResponse;
import com.apartmentmanagement.features.apartment.service.BuildingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/building")
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;

    @PostMapping("/building")
    public ResponseEntity<ApiResponse> createBuilding(@Valid @RequestBody BuildingRequest buildingRequest){
        buildingService.createBuilding(buildingRequest);
        log.info("_________");
        return ResponseEntity.ok().body(ApiResponse.success("building create success"));
    }

    @GetMapping("/buildings")
    public ResponseEntity<ApiResponse<PageResponse<BuildingResponse>>> getAllBuildings(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok().body(ApiResponse.successData(buildingService.getAllBuilding(page, size)));
    }
//
//    @PostMapping("/buildings/{id}")
//    public ResponseEntity<ApiResponse> getBuildingById(){
//        return ResponseEntity.ok().body(ApiResponse.success(""));
//    }
//
//    @PostMapping("/buildings/{id}")
//    public ResponseEntity<ApiResponse> updateBuilding(){
//        return ResponseEntity.ok().body(ApiResponse.success(""));
//    }
//
//    @PostMapping("/buildings/{id}")
//    public ResponseEntity<ApiResponse> deleteBuilding(){
//        return ResponseEntity.ok().body(ApiResponse.success(""));
//    }


}
