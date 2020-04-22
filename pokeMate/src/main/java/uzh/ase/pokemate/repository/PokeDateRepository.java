package uzh.ase.pokemate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uzh.ase.pokemate.domain.DateDomain;

public interface PokeDateRepository extends MongoRepository<DateDomain, String> {

	@Query("{'successful' : ?0, finished : ?1}")
	public List<DateDomain> findBySucessAndFinishedQuery(boolean success, boolean finished);

}
