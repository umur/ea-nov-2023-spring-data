package miu.ea.repository;

import miu.ea.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ReviewRepository extends ListCrudRepository<Review, Integer> {

}
