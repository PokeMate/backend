package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.TestDomain;
import uzh.ase.pokemate.repository.TestRepo;

@RestController
@RequestMapping("/v1/test")
public class TestController {
	private TestRepo pokeDexRepository;

	public TestController(TestRepo pokeDexRepository) {
		this.pokeDexRepository = pokeDexRepository;
	}

	@GetMapping("")
	public ResponseEntity<List<TestDomain>> all() {
		// return ok(pokeDexRepository()
		return ok(pokeDexRepository.findAll());
	}

}
