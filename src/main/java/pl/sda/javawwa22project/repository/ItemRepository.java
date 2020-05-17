package pl.sda.javawwa22project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.javawwa22project.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
