package com.apartmentmanagement.features.apartment.domain;

import com.apartmentmanagement.common.type.StautsRoom;
import java.sql.Timestamp;

public class Room {
    private Long id;
    private Long floorId;
    private String name;
    private StautsRoom stautsRoom;
    private Timestamp createDate;
}
