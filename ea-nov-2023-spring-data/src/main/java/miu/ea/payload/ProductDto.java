package miu.ea.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.ea.entity.Category;
import miu.ea.entity.Review;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private int name;
    private BigDecimal price;
    private String rating;
    List<ReviewDto> reviewList;
    private Category category;
}
