package com.assignemnts.assignment2.dto.post;

import com.assignemnts.assignment2.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFullAddressDto implements Serializable {
    private String street;
    private String zip;
    private String city;
}
