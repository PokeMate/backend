package uzh.ase.pokemate.service.mating;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.service.IFetischService;
import uzh.ase.pokemate.service.INoGoService;
import uzh.ase.pokemate.service.IPokeTypeService;
import uzh.ase.pokemate.service.IPokemonIncubator;
import uzh.ase.pokemate.service.imagegen.IImageService;
import uzh.ase.pokemate.service.naming.INameGeneratorService;

@Service
@Qualifier("incubator")
public class PokemonIncubator implements IPokemonIncubator {
	private static final String POKE_URL = "pokemate-backend/image/%s";

	@Autowired
	private PokeDexRepository pokeDexRepo;

	@Autowired
	@Qualifier("nameService")
	private INameGeneratorService nameGenService;

	@Autowired
	@Qualifier("fetischService")
	private IFetischService fetischService;

	@Autowired
	@Qualifier("nogoService")
	private INoGoService nogoService;

	@Autowired
	@Qualifier("typeService")
	private IPokeTypeService typeService;

	@Autowired
	@Qualifier("imageService")
	private IImageService imageService;

	@Override
	public PokeDexDomain incuabate(PokeDexDomain father, PokeDexDomain mother) {
		PokeDexDomain newPokemon = ParentValueMerger.merge(father, mother);

		newPokemon.setPokeDexId(getNewPokeDexId());
		newPokemon.setName(nameGenService.generateName());
		newPokemon.setGeneration("X");
		newPokemon.setFetisches(fetischService.getFetisches());
		newPokemon.setNogos(nogoService.getNoGos());
		newPokemon.setAttractedTypes(typeService.getRandomNumberOfTypes());
		List<String> nogoTypes = typeService.getRandomNumberOfTypes();
		nogoTypes.removeIf(x-> newPokemon.getAttractedTypes().contains(x));
		newPokemon.setNogoTypes(nogoTypes);
		imageService.createImage(father.getPokeDexId(), mother.getPokeDexId(), newPokemon.getPokeDexId());
		newPokemon.setImgurl(String.format(POKE_URL, newPokemon.getPokeDexId()));
		return pokeDexRepo.save(newPokemon);
	}

	private Long getNewPokeDexId() {
		Optional<PokeDexDomain> lastPokemon = pokeDexRepo.findAll().stream()
				.max((x, y) -> x.getPokeDexId().compareTo(y.getPokeDexId()));
		if(lastPokemon.isPresent()) {
			return lastPokemon.get().getPokeDexId()+1;
		}else {
			return 99999L;
		}
	}

}
