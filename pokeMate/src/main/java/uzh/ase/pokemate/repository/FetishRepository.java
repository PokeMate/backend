package uzh.ase.pokemate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.FetishDomain;

public interface FetishRepository extends MongoRepository<FetishDomain, String> {

	List<FetishDomain> findByFetishId(Long fetishId);

	FetishDomain findTopByOrderByFetishIdDesc();

}
