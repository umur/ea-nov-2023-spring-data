package edu.miu.ea.jpa.model.dto;

import lombok.Data;

@Data
public class JPAddressDTO extends JPDtoModel {

    private String street;
    private Long zip;
    private String city;

}
