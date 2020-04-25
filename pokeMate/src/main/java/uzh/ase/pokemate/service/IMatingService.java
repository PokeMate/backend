package uzh.ase.pokemate.service;

import uzh.ase.pokemate.domain.PokeDexDomain;

public interface IMatingService {
	double getMatingProbability(PokeDexDomain pokemon1, PokeDexDomain pokemon2);

	PokeDexDomain mate(PokeDexDomain pokemon1, PokeDexDomain pokemon2);
}
