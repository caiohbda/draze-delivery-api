package draze.delivery.domain.repository;

import draze.delivery.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
