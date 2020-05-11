package uzh.ase.pokemate.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.UserDomain;

public interface UserRepository extends MongoRepository<UserDomain, ObjectId> {

}
