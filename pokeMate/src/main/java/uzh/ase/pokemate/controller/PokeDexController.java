package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uzh.ase.pokemate.domain.PokeDexEntity;
import uzh.ase.pokemate.domain.PokeMon;
import uzh.ase.pokemate.dto.PokeMonDto;
import uzh.ase.pokemate.dto.PokeMonDtoMapper;
import uzh.ase.pokemate.exceptions.AseException;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.repository.PokeMonRepository;

@RestController
@RequestMapping("/v1/pokedex")
public class PokeDexController {
	private PokeDexRepository pokeDexRepository;

	public PokeDexController(PokeDexRepository pokeDexRepository) {
		this.pokeDexRepository = pokeDexRepository;
	}

	@GetMapping("")
	public ResponseEntity<List<PokeDexEntity>> all() {
		return ok(pokeDexRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PokeDexEntity> get(@PathVariable("id") Long id) {
		PokeDexEntity pokemon = this.pokeDexRepository.findByPokeDexId(id);
		return ok(pokemon);
	}

}
