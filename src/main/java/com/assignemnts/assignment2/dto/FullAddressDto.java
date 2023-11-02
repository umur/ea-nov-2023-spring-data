package com.assignemnts.assignment2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullAddressDto {
    private Long id;
    String street;
    String zip;
    String city;
}
