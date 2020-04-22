package uzh.ase.pokemate.service.mating;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.service.IMatingService;
import uzh.ase.pokemate.service.IPokemonIncubator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatingServiceTest {

	@MockBean
	@Qualifier("incubator")
	private IPokemonIncubator incubator;
	@Autowired
	@Qualifier("matingService")
	IMatingService testee;

	@Test
	public void testMatingProbability_whenValuesLow_ExpectProbabilityBelowPoint5() {
		// given
		PokeDexDomain poke1 = createPokemon("poke1", 0.1, 0.1, 0.1);
		PokeDexDomain poke2 = createPokemon("poke2", 0.1, 0.1, 0.1);
		// when
		double actual = testee.getMatingProbability(poke1, poke2);

		// then
		double expected = 0.6 / 2;
		assertThat(actual).isCloseTo(expected, within(0.00001));
	}

	@Test
	public void testMate_whenValuesHigh_ExpectMating() {
		// given
		PokeDexDomain poke1 = createPokemon("poke1", 0.9, 0.9, 0.9);
		PokeDexDomain poke2 = createPokemon("poke2", 0.9, 0.9, 0.9);
		PokeDexDomain pokemon = new PokeDexDomain();
		pokemon.setName("GENERATED!");
		when(incubator.incuabate(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(pokemon);
		// when
		PokeDexDomain actual = testee.mate(poke1, poke2);
		// then
		assertThat(actual).isNotNull();
	}

	@Test
	public void testMate_whenValuesLow_ExpectNoMating() {
		// given
		PokeDexDomain poke1 = createPokemon("poke1", 0.1, 0.1, 0.1);
		PokeDexDomain poke2 = createPokemon("poke2", 0.1, 0.1, 0.1);
		// when
		PokeDexDomain actual = testee.mate(poke1, poke2);
		// then
		assertThat(actual).isNull();
	}

	private PokeDexDomain createPokemon(String name, double attractivity, double fertility, double fitness) {
		PokeDexDomain pokemon = new PokeDexDomain();
		pokemon.setAttack("10");
		pokemon.setDefense("10");
		pokemon.setGeneration("X");
		pokemon.setHp("10");
		pokemon.setLegendary(false);
		pokemon.setSpAtk("10");
		pokemon.setSpDef("10");
		pokemon.setSpeed("10");
		pokemon.setTotal("100");
		pokemon.setType1("Type1");
		pokemon.setType2("Type2");
		pokemon.setName(name);
		pokemon.setAttractivity(attractivity);
		pokemon.setFertility(fertility);
		pokemon.setFitness(fitness);

		return pokemon;
	}

}
