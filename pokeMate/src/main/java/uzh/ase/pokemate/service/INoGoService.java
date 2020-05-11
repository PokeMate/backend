package uzh.ase.pokemate.service;

import java.util.List;

import uzh.ase.pokemate.domain.NoGoDomain;

public interface INoGoService {
	int getRandomNumberOfNoGos();

	List<NoGoDomain> getNoGos();
}
