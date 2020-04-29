package uzh.ase.pokemate.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("typeService")
public class PokeTypeService implements IPokeTypeService {
	private static final List<String> ALL_TYPES = Arrays.asList("Bug", "Dark", "Dragon", "Electric", "Fire", "Fairy",
			"Fighting", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel",
			"Water");

	@Override
	public List<String> getRandomNumberOfTypes() {
		Set<String> types = new HashSet<String>();

		int nbrOfTypes = ThreadLocalRandom.current().nextInt(0, ALL_TYPES.size() - 1);
		for (int i = 0; i < nbrOfTypes; i++) {
			types.add(ALL_TYPES.get(i));
		}
		return new ArrayList<String>(types);
	}

}
