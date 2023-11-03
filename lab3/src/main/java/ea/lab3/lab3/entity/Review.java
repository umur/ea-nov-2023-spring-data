package ea.lab3.lab3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    @JsonIgnore
    @ManyToOne
    private User user;
    @JsonIgnore
    @ManyToOne
    private Product product;
}
