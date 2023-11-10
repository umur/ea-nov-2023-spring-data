package edu.miu.ea.jpa.model.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
public class JPCategoryDTO extends JPDtoModel {

    private String name;

    @JsonManagedReference
    private List<JPProductDTO> products;

}
