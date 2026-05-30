package com.apartmentmanagement.features.apartment.domain.dto;

import com.apartmentmanagement.common.type.StatusBuilding;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class BuildingResponse {
    private Long managerId;
    private String name;
    private Integer floorNumber;
    private Timestamp createDate;
    private StatusBuilding status;
}
