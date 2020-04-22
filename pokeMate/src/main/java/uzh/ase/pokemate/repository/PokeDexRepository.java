package uzh.ase.pokemate.repository;

import java.util.List;

import uzh.ase.pokemate.domain.PokeDexDomain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PokeDexRepository extends MongoRepository<PokeDexDomain, String> {

	List<PokeDexDomain> findByPokeDexId(Long pokeDexId);

	@Query("{'generation': { $in : [?0] }}")
	List<PokeDexDomain> findByGeneration(List<String> generation);

	@Query("{generation: { $in : [?0] }, type1: { $in : [?1]} }")
	List<PokeDexDomain> findByGenerationAndType(List<String> generation, List<String> type1);

}
