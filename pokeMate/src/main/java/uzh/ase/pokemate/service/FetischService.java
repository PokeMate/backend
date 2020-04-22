package uzh.ase.pokemate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uzh.ase.pokemate.domain.FetischDomain;
import uzh.ase.pokemate.repository.FetischRepository;

@Service
@Qualifier("fetischService")
public class FetischService implements IFetischService {

	@Autowired
	private FetischRepository fetischRepo;

	@Override
	public int getRandomNumberOfFetisches() {
		return ThreadLocalRandom.current().nextInt(0, 3);
	}

	@Override
	public List<FetischDomain> getFetisches(int nbrOfFetisches) {
		List<FetischDomain> fetisches = new ArrayList<FetischDomain>();
		for (int i = 0; i < nbrOfFetisches; i++) {
			fetisches.addAll(fetischRepo.findByFetishId(getRandomFetisch()));
		}
		return fetisches;
	}

	private Long getRandomFetisch() {
		FetischDomain lastFetisch = fetischRepo.findTopByOrderByFetishIdDesc();
		Long max = lastFetisch.getFetishId();
		return (long) ThreadLocalRandom.current().nextInt(0, (int) (max + 1));
	}

	@Override
	public List<FetischDomain> getFetisches() {
		int nbrOfFetisches = getRandomNumberOfFetisches();
		List<FetischDomain> fetisches = new ArrayList<FetischDomain>();
		for (int i = 0; i < nbrOfFetisches; i++) {
			fetisches.addAll(fetischRepo.findByFetishId(getRandomFetisch()));
		}
		return fetisches;
	}

}
