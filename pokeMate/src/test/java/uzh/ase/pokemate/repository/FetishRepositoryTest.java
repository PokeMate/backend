package uzh.ase.pokemate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import uzh.ase.pokemate.domain.FetishDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FetishRepositoryTest {

	@Autowired
	private FetishRepository repo;;

	@Before
	public void init() {
		repo.deleteAll();
	}

	@Test
	public void testFindAll_whenFetishesExist_expect3Fetishes() {
		List<FetishDomain> fetishes = createFetishes(3);
		repo.insert(fetishes);

		List<FetishDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(3);
	}

	@Test
	public void testFindAll_whenNoFetishesExist_expect0Fetishes() {
		List<FetishDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(0);
	}

	private List<FetishDomain> createFetishes(int nbrOfFetishes) {
		List<FetishDomain> fetishes = new ArrayList<>();
		for (int i = 0; i < nbrOfFetishes; i++) {
			FetishDomain fet = new FetishDomain();
			fet.setFetish(String.format("Fet%s", i));
			fet.setFetishId(Long.valueOf(i));
			fetishes.add(fet);
		}
		return fetishes;
	}
}
