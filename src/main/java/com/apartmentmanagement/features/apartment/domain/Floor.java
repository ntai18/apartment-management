package com.apartmentmanagement.features.apartment.domain;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Floor {
    private Long id;
    private Long buildingId;
    private String name;
    private Integer roomNumber;
    private Timestamp createDate;

}
