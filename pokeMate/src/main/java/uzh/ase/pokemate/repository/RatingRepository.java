package uzh.ase.pokemate.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.RatingDomain;

public interface RatingRepository extends MongoRepository<RatingDomain, ObjectId> {
	Optional<RatingDomain> findById(ObjectId id);

}
