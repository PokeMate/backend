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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uzh.ase.pokemate.domain.DateEntity;
import uzh.ase.pokemate.domain.PokeDexEntity;
import uzh.ase.pokemate.domain.PokeMon;
import uzh.ase.pokemate.dto.PokeMonDto;
import uzh.ase.pokemate.dto.PokeMonDtoMapper;
import uzh.ase.pokemate.exceptions.AseException;
import uzh.ase.pokemate.repository.PokeDateRepository;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.repository.PokeMonRepository;

@RestController
@RequestMapping("/v1/dates")
public class DateController {
	private PokeDateRepository dateRepository;

	public DateController(PokeDateRepository dateRepository) {
		this.dateRepository = dateRepository;
	}

//	@Secured("ROLE_ADMIN")
//	@GetMapping("")
//	public ResponseEntity<List<DateEntity>> all() {
//		return ok(dateRepository.findAll());
//	}

	@GetMapping("")
	public ResponseEntity<List<DateEntity>> get(@RequestParam boolean finished, @RequestParam boolean successful) {
		return ok(this.dateRepository.findBySucAndFin(successful, finished));
		// return ResponseEntity.ok();
		// return ok(this.dateRepository.findDateBySuccessAndFinished(successful,
		// finished).stream().collect(Collectors.toList()));
	}
}
