package com.assginments.lab.entity.Generic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

// @Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class GenericEntity {
    private int id;

}
