package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.RatingDomain;
import uzh.ase.pokemate.exceptions.AseException;
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
	public ResponseEntity<List<RatingDomain>> all() {
		return ok(ratingRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RatingDomain> get(@PathVariable("id") String id) {
		RatingDomain pokeRating = this.ratingRepository.findById(new ObjectId(id))
				.orElseThrow(() -> new AseException());
		return ok(pokeRating);
	}
}
