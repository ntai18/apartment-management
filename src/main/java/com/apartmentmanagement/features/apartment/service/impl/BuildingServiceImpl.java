package com.apartmentmanagement.features.apartment.service.impl;

import com.apartmentmanagement.features.apartment.domain.Building;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingRequest;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingResponse;
import com.apartmentmanagement.features.apartment.domain.dto.PageResponse;
import com.apartmentmanagement.features.apartment.mapper.BuildingMapper;
import com.apartmentmanagement.features.apartment.service.BuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingMapper buildingMapper;

    @Override
    public void createBuilding(BuildingRequest buildingDto) {
        buildingMapper.createBuilding(buildingDto);
    }

    @Override
    public PageResponse<BuildingResponse> getAllBuilding(int page, int size) {
        if (page > 100)
            page = 100;
        if (size > 50)
            size = 50;
        PageHelper.startPage(page, size);
        List<Building> building = buildingMapper.getAllBuilding();
        PageInfo<Building> buildingPageInfo = new PageInfo<>(building);
        List<BuildingResponse> buildingResponse = building.stream().map(e -> BuildingResponse.builder()
                .managerId(e.getManagerId())
                .name(e.getName())
                .floorNumber(e.getFloorNumber())
                .createDate(e.getCreateDate())
                .status(e.getStatus())
                .build())
        .toList();
        return PageResponse.<BuildingResponse>builder()
                .content(buildingResponse)
                .page(buildingPageInfo.getPageNum())
                .size(buildingPageInfo.getPageSize())
                .totalPage(buildingPageInfo.getPages())
                .totalElement((int) buildingPageInfo.getTotal())
                .build();
    }
}
