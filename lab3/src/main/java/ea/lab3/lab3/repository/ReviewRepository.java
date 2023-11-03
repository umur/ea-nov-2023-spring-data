package ea.lab3.lab3.repository;

import ea.lab3.lab3.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByProduct_Id(int productId);
}
