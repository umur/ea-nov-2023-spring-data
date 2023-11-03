package miu.ea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Address {
    private int id;
    private String street;
    private String zip;
    private String city;
}
