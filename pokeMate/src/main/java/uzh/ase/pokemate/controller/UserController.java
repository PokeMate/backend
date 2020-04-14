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

import uzh.ase.pokemate.domain.UserDomain;
import uzh.ase.pokemate.exceptions.AseException;
import uzh.ase.pokemate.repository.UserRepository;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	private UserRepository userRepository;

	public UserController(UserRepository ratingRepository) {
		this.userRepository = ratingRepository;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<UserDomain>> all() {
		return ok(userRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDomain> get(@PathVariable("id") String id) {
		UserDomain pokeRating = this.userRepository.findById(new ObjectId(id))
				.orElseThrow(() -> new AseException());
		return ok(pokeRating);
	}
}
