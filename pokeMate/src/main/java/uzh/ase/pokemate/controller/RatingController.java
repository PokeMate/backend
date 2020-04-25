package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.domain.RatingDomain;
import uzh.ase.pokemate.dto.RatingDto;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.repository.RatingRepository;

@RestController
@RequestMapping("/v1/rating")
public class RatingController {
	private RatingRepository ratingRepository;
	private PokeDexRepository pokeDexRepository;

	public RatingController(RatingRepository ratingRepository, PokeDexRepository pokeDexRepository) {
		this.ratingRepository = ratingRepository;
		this.pokeDexRepository = pokeDexRepository;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<RatingDomain>> all() {
		return ok(ratingRepository.findAll());
	}

	@GetMapping("/ratingId/{id}")
	public ResponseEntity<RatingDomain> getByRating(@PathVariable("id") Long id) {
		RatingDomain pokeRating = this.ratingRepository.findByRatingId(id);
		return ok(pokeRating);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RatingDomain> get(@PathVariable("id") Long pokeDexId) {
		PokeDexDomain pokemon = this.pokeDexRepository.findByPokeDexId(pokeDexId).get(0);
		List<RatingDomain> pokeRating = this.ratingRepository.findByPokemon(pokemon);
		RatingDomain avgRating = new RatingDomain();
		int name = 0;
		int image = 0;
		int rating = 0;
		if (!pokeRating.isEmpty()) {
			name = pokeRating.stream().map(x -> x.getName()).reduce(0, Integer::sum) / pokeRating.size();
			image = pokeRating.stream().map(x -> x.getImage()).reduce(0, Integer::sum) / pokeRating.size();
			rating = pokeRating.stream().map(x -> x.getRating()).reduce(0, Integer::sum) / pokeRating.size();
		}

		avgRating.setName(name);
		avgRating.setImage(image);
		avgRating.setRating(rating);
		avgRating.setPokemon(pokemon);
		return ok(avgRating);
	}

	@PostMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<RatingDomain> post(@PathVariable("id") Long id, @RequestBody RatingDto request) {

		List<PokeDexDomain> poke1 = this.pokeDexRepository.findByPokeDexId(id);
		if (poke1.isEmpty()) {
			return badRequest().build();
		}
		PokeDexDomain pokemon = poke1.get(0);
		RatingDomain newRating = new RatingDomain();
		newRating.setImage(request.getImage());
		newRating.setName(request.getName());
		newRating.setRating(request.getRating());
		newRating.setPokemon(pokemon);
		RatingDomain saved = this.ratingRepository.save(newRating);
		return ok(saved);
	}
}
