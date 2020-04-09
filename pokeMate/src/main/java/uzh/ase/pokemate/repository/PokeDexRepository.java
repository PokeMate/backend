package uzh.ase.pokemate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uzh.ase.pokemate.domain.DateEntity;
import uzh.ase.pokemate.domain.PokeDexEntity;

import uzh.ase.pokemate.domain.DateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokeDexRepository extends JpaRepository<PokeDexEntity, Long> {

	@Query(value = "SELECT * FROM pokedex t WHERE " + "t.pokeDexId = :pokeDexId", nativeQuery = true)
	PokeDexEntity findByPokeDexId(@Param("pokeDexId") Long pokeDexId);
}
