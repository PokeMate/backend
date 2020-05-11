package uzh.ase.pokemate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uzh.ase.pokemate.domain.FetishDomain;
import uzh.ase.pokemate.repository.FetishRepository;

@Service
@Qualifier("fetischService")
public class FetischService implements IFetischService {

	@Autowired
	private FetishRepository fetischRepo;

	@Override
	public int getRandomNumberOfFetisches() {
		return ThreadLocalRandom.current().nextInt(0, 3);
	}

	@Override
	public List<FetishDomain> getFetisches(int nbrOfFetisches) {
		List<FetishDomain> fetisches = new ArrayList<>();
		for (int i = 0; i < nbrOfFetisches; i++) {
			fetisches.addAll(fetischRepo.findByFetishId(getRandomFetisch()));
		}
		return fetisches;
	}

	private Long getRandomFetisch() {
		FetishDomain lastFetisch = fetischRepo.findTopByOrderByFetishIdDesc();
		if(lastFetisch == null) {
			return -1L;
		}
		Long max = lastFetisch.getFetishId();
		return (long) ThreadLocalRandom.current().nextInt(0, (int) (max + 1));
	}

	@Override
	public List<FetishDomain> getFetisches() {
		int nbrOfFetisches = getRandomNumberOfFetisches();
		List<FetishDomain> fetisches = new ArrayList<>();
		for (int i = 0; i < nbrOfFetisches; i++) {
			fetisches.addAll(fetischRepo.findByFetishId(getRandomFetisch()));
		}
		return fetisches;
	}

}
