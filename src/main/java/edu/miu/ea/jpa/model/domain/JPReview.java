package edu.miu.ea.jpa.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class JPReview extends JPBaseEntityWithIdAuto {

    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    private JPUser user;

}
