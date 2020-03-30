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

import uzh.ase.pokemate.domain.PokeMon;
import uzh.ase.pokemate.dto.PokeMonDto;
import uzh.ase.pokemate.dto.PokeMonDtoMapper;
import uzh.ase.pokemate.exceptions.AseException;
import uzh.ase.pokemate.repository.PokeMonRepository;

@RestController
@RequestMapping("/v1/pokemons")
public class PokeMonRestController {
	private PokeMonRepository pokeRepository;

	public PokeMonRestController(PokeMonRepository pokeRepo) {
		this.pokeRepository = pokeRepo;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<PokeMonDto>> all() {
		return ok(pokeRepository.findAll().parallelStream().map(entity -> PokeMonDtoMapper.entityToDto(entity))
				.collect(Collectors.toList()));
	}

	@PostMapping("")
	public ResponseEntity<PokeMonDto> save(@RequestBody PokeMonDto pokemonDto, HttpServletRequest request) {
		PokeMon saved = this.pokeRepository.save(PokeMonDtoMapper.dtoToEntity(pokemonDto));
		return created(ServletUriComponentsBuilder.fromContextPath(request).path("/v1/pokemons/{id}")
				.buildAndExpand(saved.getId()).toUri()).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PokeMonDto> get(@PathVariable("id") Long id) {
		PokeMon pokemon = this.pokeRepository.findById(id).orElseThrow(() -> new AseException());
		return ok(PokeMonDtoMapper.entityToDto(pokemon));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PokeMonDto> delete(@PathVariable("id") Long id) {
		PokeMon existed = this.pokeRepository.findById(id).orElseThrow(() -> new AseException());
		this.pokeRepository.delete(existed);
		return noContent().build();
	}
}