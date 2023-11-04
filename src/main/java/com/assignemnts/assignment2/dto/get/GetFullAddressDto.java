package com.assignemnts.assignment2.dto.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFullAddressDto implements Serializable {
    private Long id;
    private String street;
    private String zip;
    private String city;
}
