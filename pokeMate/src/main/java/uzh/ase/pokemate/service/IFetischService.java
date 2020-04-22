package uzh.ase.pokemate.service;

import java.util.List;

import uzh.ase.pokemate.domain.FetischDomain;

public interface IFetischService {

	int getRandomNumberOfFetisches();

	List<FetischDomain> getFetisches(int nbrOfFetisches);

	List<FetischDomain> getFetisches();
}
