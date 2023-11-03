package ea.lab3.lab3.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<ReviewDto> review;
    private AddressDto address;

}
