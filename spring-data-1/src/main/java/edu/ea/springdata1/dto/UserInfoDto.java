package edu.ea.springdata1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    private Integer id;
    private String email;
    private String  firstName;
    private String  lastname;
}
