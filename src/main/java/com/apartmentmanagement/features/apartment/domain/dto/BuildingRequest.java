package com.apartmentmanagement.features.apartment.domain.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingRequest {
    private String name;
    @Min(value = -10, message = " < -10")
    @Max(value = 200, message = " > 200")
    private Integer floorNumber;
}
