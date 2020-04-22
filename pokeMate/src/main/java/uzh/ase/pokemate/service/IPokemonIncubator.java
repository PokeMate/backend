package uzh.ase.pokemate.service;

import uzh.ase.pokemate.domain.PokeDexDomain;

public interface IPokemonIncubator {

	PokeDexDomain incuabate(PokeDexDomain father, PokeDexDomain mother);
}
