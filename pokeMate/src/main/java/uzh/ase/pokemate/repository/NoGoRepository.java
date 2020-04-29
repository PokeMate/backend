package uzh.ase.pokemate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uzh.ase.pokemate.domain.NoGoDomain;

public interface NoGoRepository extends MongoRepository<NoGoDomain, String> {
	List<NoGoDomain> findByNogoId(Long nogoId);

	NoGoDomain findTopByOrderByNogoIdDesc();
}
