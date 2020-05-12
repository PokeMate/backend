package uzh.ase.pokemate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uzh.ase.pokemate.domain.NoGoDomain;
import uzh.ase.pokemate.repository.NoGoRepository;

@Service
@Qualifier("nogoService")
public class NoGoService implements INoGoService {
	@Autowired
	private NoGoRepository nogoRepo;

	@Override
	public int getRandomNumberOfNoGos() {
		return ThreadLocalRandom.current().nextInt(0, 3);
	}

	@Override
	public List<NoGoDomain> getNoGos() {
		int nbrOfFetisches = getRandomNumberOfNoGos();
		List<NoGoDomain> fetisches = new ArrayList<>();
		for (int i = 0; i < nbrOfFetisches; i++) {
			fetisches.addAll(nogoRepo.findByNogoId(getRandomNoGo()));
		}
		return fetisches;
	}

	private Long getRandomNoGo() {
		NoGoDomain lastFetisch = nogoRepo.findTopByOrderByNogoIdDesc();
		if (lastFetisch == null) {
			return -1L;
		}
		Long max = lastFetisch.getNogoId();
		return (long) ThreadLocalRandom.current().nextInt(0, (int) (max + 1));
	}

}
