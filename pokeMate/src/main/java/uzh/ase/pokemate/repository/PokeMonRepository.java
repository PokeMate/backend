package uzh.ase.pokemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uzh.ase.pokemate.domain.PokeMon;

public interface PokeMonRepository extends JpaRepository<PokeMon, Long> {

}