package edu.miu.ea.jpa.model.dto;

import lombok.Data;

@Data
public class JPUserBasicDTO extends JPDtoModel {

    private String email;
    private String firstname;
    private String  lastname;

}
