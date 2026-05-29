package com.apartmentmanagement.features.apartment.domain;

import com.apartmentmanagement.common.type.Status;
import java.sql.Timestamp;

public class Building {
    private Long id;
    private Long managerId;
    private String name;
    private Integer floorNumber;
    private Timestamp createDate;
    private Status status;
}
