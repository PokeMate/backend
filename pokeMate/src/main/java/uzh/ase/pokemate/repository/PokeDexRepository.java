package uzh.ase.pokemate.repository;

import java.util.List;

import uzh.ase.pokemate.domain.PokeDexDomain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokeDexRepository extends MongoRepository<PokeDexDomain, String> {

	List<PokeDexDomain> findByPokeDexId(Long pokeDexId);

}
