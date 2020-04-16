package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uzh.ase.pokemate.domain.DateDomain;
import uzh.ase.pokemate.repository.PokeDateRepository;

@RestController
@RequestMapping("/v1/dates")
public class DateController {
	private PokeDateRepository dateRepository;

	public DateController(PokeDateRepository dateRepository) {
		this.dateRepository = dateRepository;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<DateDomain>> all() {
		return ok(dateRepository.findAll());
	}

	//curl -X GET 'http://localhost:8080/v1/dates?successful=true&finished=true'
	@GetMapping("/detail")
	public ResponseEntity<List<DateDomain>> get(@RequestParam boolean finished, @RequestParam boolean successful) {
		return ok(this.dateRepository.findBySucessAndFinishedQuery(successful, finished));
	}

	@PostMapping("")
	public ResponseEntity<DateDomain> save(@RequestBody DateDomain dateEntity, HttpServletRequest request) {
		DateDomain saved = this.dateRepository.save(dateEntity);
		return created(ServletUriComponentsBuilder.fromContextPath(request).path("/v1/dates/{id}")
				.buildAndExpand(saved.getId()).toUri()).build();
	}
}
