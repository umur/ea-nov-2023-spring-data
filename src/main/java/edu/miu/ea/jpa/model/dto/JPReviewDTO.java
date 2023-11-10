package edu.miu.ea.jpa.model.dto;

import lombok.Data;

@Data
public class JPReviewDTO extends JPDtoModel {

    private String comment;
    private JPUserBasicDTO user;

}
