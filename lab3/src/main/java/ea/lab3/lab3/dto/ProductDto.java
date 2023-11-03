package ea.lab3.lab3.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
    private CategoryDto category;
    private List<ReviewDto> review;
}
