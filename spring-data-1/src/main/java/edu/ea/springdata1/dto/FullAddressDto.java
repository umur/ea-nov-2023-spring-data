package edu.ea.springdata1.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullAddressDto {

    private Integer id;
    private String street;
    private Integer zip;
    private String city;

}
