package com.apartmentmanagement.features.apartment.domain;

import com.apartmentmanagement.common.type.StautsRoom;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Room {
    private Long id;
    private Long floorId;
    private String name;
    private StautsRoom stautsRoom;
    private Timestamp createDate;
}
