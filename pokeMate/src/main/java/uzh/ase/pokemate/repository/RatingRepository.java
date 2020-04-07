package uzh.ase.pokemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzh.ase.pokemate.domain.RatingEntity;
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
}
