package uzh.ase.pokemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import uzh.ase.pokemate.domain.DateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokeDateRepository extends JpaRepository<DateEntity, Long> {

	@Query(value = "SELECT * FROM pokedate t WHERE "
			+ "LOWER(t.successful) LIKE LOWER(CONCAT('%',:successful, '%')) OR "
			+ "LOWER(t.finished) LIKE LOWER(CONCAT('%',:finished, '%'))", nativeQuery = true)
	List<DateEntity> findBySucAndFin(@Param("successful") boolean successful,
			@Param("finished") boolean finished);

	/*
	 * @Query("select * from pokedate d where d.successful = :successful and d.finished = :finished"
	 * ) List<DateEntity> findDateBySuccessAndFinished(@Param("successful") boolean
	 * successful,
	 * 
	 * @Param("finished") boolean finished);
	 */
}
