package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.repository.PokeDexRepository;

@RestController
@RequestMapping("/v1/pokedex")
public class PokeDexController {
	private PokeDexRepository pokeDexRepository;

	public PokeDexController(PokeDexRepository pokeDexRepository) {
		this.pokeDexRepository = pokeDexRepository;
	}

	@GetMapping("")
	public ResponseEntity<List<PokeDexDomain>> all() {
		return ok(pokeDexRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<PokeDexDomain>> get(@PathVariable("id") Long id) {
		List<PokeDexDomain> pokemon = this.pokeDexRepository.findByPokeDexId(id);
		return ok(pokemon);
	}

}
