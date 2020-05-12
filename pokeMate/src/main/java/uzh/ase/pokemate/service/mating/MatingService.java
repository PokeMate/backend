package uzh.ase.pokemate.service.mating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.service.IMatingService;
import uzh.ase.pokemate.service.IPokemonIncubator;

@Service
@Qualifier("matingService")
public class MatingService implements IMatingService {

	@Autowired
	@Qualifier("incubator")
	private IPokemonIncubator incubator;

	@Override
	public double getMatingProbability(PokeDexDomain pokemon1, PokeDexDomain pokemon2) {
		double sumPok1 = pokemon1.getAttractivity() + pokemon1.getFertility() + pokemon1.getFitness();
		double sumPok2 = pokemon2.getAttractivity() + pokemon2.getFertility() + pokemon2.getFitness();

		return (sumPok1 + sumPok2) / 2;
	}

	@Override
	public PokeDexDomain mate(PokeDexDomain pokemon1, PokeDexDomain pokemon2) {
		PokeDexDomain baby = null;
		if (getMatingProbability(pokemon1, pokemon2) > 0.5) {
			baby = incubator.incuabate(pokemon1, pokemon2);
		}
		return baby;
	}
}
