package edu.miu.ea.jpa.model.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPBaseEntityWithIdManual extends JPBaseEntity {

    @Id
    private Long id;

}
