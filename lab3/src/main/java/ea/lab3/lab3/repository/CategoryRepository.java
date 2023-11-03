package ea.lab3.lab3.repository;

import ea.lab3.lab3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer> {
}
