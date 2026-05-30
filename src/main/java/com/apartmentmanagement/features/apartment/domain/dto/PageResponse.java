package com.apartmentmanagement.features.apartment.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PageResponse <T>{
    private List<T> content;
    private int page;
    private int size;
    private int totalPage;
    private int totalElement;
}
