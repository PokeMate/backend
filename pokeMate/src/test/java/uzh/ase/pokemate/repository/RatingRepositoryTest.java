package uzh.ase.pokemate.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.domain.RatingDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RatingRepositoryTest {

	@Autowired
	private RatingRepository repo;
	List<PokeDexDomain> pokemons;

	@Before
	public void init() {
		repo.deleteAll();
		pokemons = createPokemon(3);
		List<RatingDomain> ratings = createRating(pokemons);
		repo.insert(ratings);
	}

	@Test
	public void testRatingRepositoryFindAll_whenRatingsExist_expect3Ratings() {
		List<RatingDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(3);
	}

	@Test
	public void testRatingRepositoryFindByPokemon_whenRatingExists_expect1Ratings() {
		for (PokeDexDomain pokemon : pokemons) {
			List<RatingDomain> ratings = repo.findByPokemon(pokemon);
			assertThat(ratings.size()).isEqualTo(1);
		}
	}

	@Test
	public void testRatingRepositoryFindByPokemon_whenNoRatingExists_expect0Ratings() {
		List<RatingDomain> ratings = repo.findByPokemon(createPokemon(1).get(0));
		assertTrue(ratings.isEmpty());
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

	private List<RatingDomain> createRating(List<PokeDexDomain> pokemons) {
		List<RatingDomain> ratings = new ArrayList<RatingDomain>();
		ThreadLocalRandom rnd = ThreadLocalRandom.current();

		for (PokeDexDomain pokemon : pokemons) {
			RatingDomain rating = new RatingDomain();
			rating.setId(new ObjectId());
			rating.setPokemon(pokemon);
			rating.setImage(rnd.nextInt(0, 11));
			rating.setName(rnd.nextInt(0, 11));
			rating.setRating(rnd.nextInt(0, 11));
			ratings.add(rating);
		}
		return ratings;
	}
}
