package uzh.ase.pokemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzh.ase.pokemate.domain.PokeDexEntity;

public interface PokeDexRepository extends JpaRepository<PokeDexEntity, Long> {
}
