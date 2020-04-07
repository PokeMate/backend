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
import uzh.ase.pokemate.domain.RatingEntity;
import uzh.ase.pokemate.dto.PokeMonDto;
import uzh.ase.pokemate.dto.PokeMonDtoMapper;
import uzh.ase.pokemate.exceptions.AseException;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.repository.PokeMonRepository;
import uzh.ase.pokemate.repository.RatingRepository;

@RestController
@RequestMapping("/v1/rating")
public class RatingController {
	private RatingRepository ratingRepository;

	public RatingController(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<RatingEntity>> all() {
		return ok(ratingRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RatingEntity> get(@PathVariable("id") Long id) {
		RatingEntity pokeRating = this.ratingRepository.findById(id).orElseThrow(() -> new AseException());
		return ok(pokeRating);
	}
}
