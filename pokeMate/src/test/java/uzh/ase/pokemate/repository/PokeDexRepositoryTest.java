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

import uzh.ase.pokemate.domain.PokeDexDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PokeDexRepositoryTest {

	@Autowired
	private PokeDexRepository repo;
	List<PokeDexDomain> pokemons;

	@Before
	public void init() {
		repo.deleteAll();
		pokemons = createPokemon(3);
		repo.insert(pokemons);
	}

	@Test
	public void testFindAll_whenDatesExist_expect3Ratings() {
		List<PokeDexDomain> ratings = repo.findAll();
		assertThat(ratings.size()).isEqualTo(3);
	}

	@Test
	public void testFindByPokeDexId_whenExists() {
		for (long l = 0; l < 3; l++) {
			assertThat(repo.findByPokeDexId(l).size()).isEqualTo(1);
		}
	}

	@Test
	public void testFindByPokeDexId_whenNotExists() {
		assertThat(repo.findByPokeDexId(9999L).size()).isEqualTo(0);
	}

	@Test
	public void testFindByGenerationAndType() {
		List<String> allGenerations = List.of("0", "1", "2");
		List<String> allTypes = List.of("Grass", "Poison");
		assertThat(repo.findByGenerationAndType(allGenerations, allTypes).size()).isEqualTo(3);
		assertThat(repo.findByGenerationAndType(List.of("0", "1"), allTypes).size()).isEqualTo(2);
		assertThat(repo.findByGenerationAndType(allGenerations, List.of("Poison")).size()).isEqualTo(1);
	}

	private List<PokeDexDomain> createPokemon(int nbrOfPokemons) {
		List<PokeDexDomain> pokemons = new ArrayList<>();
		for (int i = 0; i < nbrOfPokemons; i++) {
			PokeDexDomain pokemon = new PokeDexDomain();
			pokemon.setId(new ObjectId());
			pokemon.setPokeDexId(Long.valueOf(i));
			pokemon.setName(String.format("pokemon%s", i));
			pokemon.setGeneration(String.valueOf(i));
			pokemon.setType1("Grass");
			if ((i + 1) % 2 == 0) {
				pokemon.setType1("Poison");
			}
			pokemons.add(pokemon);
		}
		return pokemons;
	}

}
