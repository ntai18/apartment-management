package com.apartmentmanagement.features.apartment.mapper;

import com.apartmentmanagement.features.apartment.domain.Building;
import com.apartmentmanagement.features.apartment.domain.dto.BuildingRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuildingMapper {
    void createBuilding(BuildingRequest buildingDto);

    List<Building> getAllBuilding();
}
