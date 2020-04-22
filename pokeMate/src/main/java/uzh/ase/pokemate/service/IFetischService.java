package uzh.ase.pokemate.service;

import java.util.List;

import uzh.ase.pokemate.domain.FetishDomain;

public interface IFetischService {

	int getRandomNumberOfFetisches();

	List<FetishDomain> getFetisches(int nbrOfFetisches);

	List<FetishDomain> getFetisches();
}
