package uzh.ase.pokemate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uzh.ase.pokemate.domain.TestDomain;

public interface TestRepo extends MongoRepository<TestDomain, String> {

}
