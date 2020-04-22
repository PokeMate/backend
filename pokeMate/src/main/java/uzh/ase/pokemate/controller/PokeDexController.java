package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.repository.PokeDexRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/pokedex")
public class PokeDexController {
	private PokeDexRepository pokeDexRepository;

	public PokeDexController(PokeDexRepository pokeDexRepository) {
		this.pokeDexRepository = pokeDexRepository;
	}

	// http://localhost:8080/v1/pokedex?generations=1,2&types=Grass,Fire
	// http://localhost:8080/v1/pokedex
	@GetMapping("")
	public ResponseEntity<List<PokeDexDomain>> get(@RequestParam(required = false) String[] generations,
			@RequestParam(required = false) String[] types) {
		List<PokeDexDomain> pokemon;
		pokemon = this.pokeDexRepository.findAll();
		if (generations != null || types != null) {
			List<String> genList = generations == null ? new ArrayList<String>() : Arrays.asList(generations);
			List<String> typeList = types == null ? new ArrayList<String>() : Arrays.asList(types);
			pokemon = pokemon.stream().filter(pok -> (genList.isEmpty() || genList.contains(pok.getGeneration())
					&& (typeList.isEmpty() || typeList.contains(pok.getType1())))).collect(Collectors.toList());
		}
		pokemon.sort((x, y) -> x.getPokeDexId().compareTo(y.getPokeDexId()));
		return ok(pokemon);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<PokeDexDomain>> get(@PathVariable("id") Long id) {
		List<PokeDexDomain> pokemon = this.pokeDexRepository.findByPokeDexId(id);
		return ok(pokemon);
	}

}
