package com.apartmentmanagement.features.apartment.service;

import com.apartmentmanagement.features.apartment.domain.dto.BuildingRequest;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingResponse;
import com.apartmentmanagement.features.apartment.domain.dto.PageResponse;

public interface BuildingService {
    void createBuilding(BuildingRequest buildingDto);

    PageResponse<BuildingResponse> getAllBuilding(int page, int size);
}
