package uzh.ase.pokemate.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.domain.RatingDomain;

public interface RatingRepository extends MongoRepository<RatingDomain, ObjectId> {
	Optional<RatingDomain> findById(ObjectId id);
	

	RatingDomain findByRatingId(Long ratingId);
	
	List<RatingDomain> findByPokemon(PokeDexDomain pokemon);

}
