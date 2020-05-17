package pl.sda.javawwa22project.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.javawwa22project.entity.Item;

// 2). create item repository
@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
}
