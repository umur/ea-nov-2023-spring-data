package miu.ea.repository;

import miu.ea.entity.Review;
import org.springframework.data.repository.ListCrudRepository;


public interface ReviewRepository extends ListCrudRepository<Review, Integer> {

    /**
     *   Find reviews of the product whose id is id.
     */
    //public List<Review> findCommentLike(BigDecimal productId);


}
