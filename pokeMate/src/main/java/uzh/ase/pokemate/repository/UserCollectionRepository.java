package uzh.ase.pokemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import uzh.ase.pokemate.domain.DateEntity;
import uzh.ase.pokemate.domain.UserCollectionEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserCollectionRepository extends JpaRepository<UserCollectionEntity, Long> {

	@Query(value = "SELECT * FROM usercollection t WHERE " + "t.userId = :userId", nativeQuery = true)
	List<UserCollectionEntity> findByUser(@Param("userId") Long userId);
}
