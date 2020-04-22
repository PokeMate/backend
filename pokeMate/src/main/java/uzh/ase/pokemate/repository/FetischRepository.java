package uzh.ase.pokemate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.FetischDomain;

public interface FetischRepository extends MongoRepository<FetischDomain, String> {

	List<FetischDomain> findByFetishId(Long fetishId);

	FetischDomain findTopByOrderByFetishIdDesc();

}
