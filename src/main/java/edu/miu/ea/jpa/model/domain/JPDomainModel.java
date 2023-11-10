package edu.miu.ea.jpa.model.domain;

import edu.miu.ea.jpa.model.JPModel;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPDomainModel extends JPModel {
}
