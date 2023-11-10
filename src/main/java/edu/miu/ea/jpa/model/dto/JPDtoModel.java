package edu.miu.ea.jpa.model.dto;

import edu.miu.ea.jpa.model.JPModel;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPDtoModel extends JPModel {

    private Long id;

}
