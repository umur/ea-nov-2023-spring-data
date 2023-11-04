package com.assignemnts.assignment2.dto.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFullUserDto implements Serializable {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @JsonManagedReference
    private List<PostFullReviewDto> reviewList = new ArrayList<>();
    private PostFullAddressDto address;

}
