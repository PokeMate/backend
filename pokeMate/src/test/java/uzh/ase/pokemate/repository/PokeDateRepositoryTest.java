package uzh.ase.pokemate.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import uzh.ase.pokemate.domain.DateDomain;
import uzh.ase.pokemate.domain.PokeDexDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PokeDateRepositoryTest {

	@Autowired
	private PokeDateRepository repo;
	List<PokeDexDomain> pokemons;

	@Before
	public void init() {
		repo.deleteAll();
		pokemons = createPokemon(3);
	}

	@Test
	public void testFindAll_whenDatesExist_expect3Ratings() {
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), true, true));
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), true, true));
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), true, true));
		List<DateDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(3);
	}

	@Test
	public void testFindAll_whenNoDateExist_expect0Ratings() {
		List<DateDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(0);
	}
	
	
	@Test
	public void FindBySucessAndFinishedQuery_whenRatingExists_expect1Ratings() {
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), true, true));
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), true, false));
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), false, false));
		repo.insert(createDate(pokemons.get(0), pokemons.get(1), pokemons.get(2), false, true));

		List<DateDomain> ratings = repo.findBySucessAndFinishedQuery(true, true);
		assertThat(ratings.size()).isEqualTo(1);
		ratings = repo.findBySucessAndFinishedQuery(true, false);
		assertThat(ratings.size()).isEqualTo(1);
		ratings = repo.findBySucessAndFinishedQuery(false, false);
		assertThat(ratings.size()).isEqualTo(1);
		ratings = repo.findBySucessAndFinishedQuery(false, true);
		assertThat(ratings.size()).isEqualTo(1);
		
	}

	private List<PokeDexDomain> createPokemon(int nbrOfPokemons) {
		List<PokeDexDomain> pokemons = new ArrayList<>();
		for (int i = 0; i < nbrOfPokemons; i++) {
			PokeDexDomain pokemon = new PokeDexDomain();
			pokemon.setId(new ObjectId());
			pokemon.setName(String.format("pokemon%s", i));
			pokemons.add(pokemon);
		}
		return pokemons;
	}

	private DateDomain createDate(PokeDexDomain poke1,PokeDexDomain poke2,PokeDexDomain baby,boolean success, boolean finished) {
			DateDomain date = new DateDomain();
			date.setFinished(finished);
			date.setSuccessful(success);
			date.setPokemon1(poke1);
			date.setPokemon2(poke2);
			date.setPokeBaby(baby);
			return date;
	}

}
