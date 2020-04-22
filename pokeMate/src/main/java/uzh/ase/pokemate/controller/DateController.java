package uzh.ase.pokemate.controller;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.domain.DateDomain;
import uzh.ase.pokemate.domain.PokeDexDomain;
import uzh.ase.pokemate.dto.DateRequestDto;
import uzh.ase.pokemate.repository.PokeDateRepository;
import uzh.ase.pokemate.repository.PokeDexRepository;
import uzh.ase.pokemate.service.IMatingService;

@RestController
@RequestMapping("/v1/dates")
public class DateController {
	private PokeDexRepository pokeDexRepository;
	private PokeDateRepository dateRepository;
	private IMatingService matingService;

	public DateController(PokeDateRepository dateRepository, PokeDexRepository pokeDexRepository,
			IMatingService matingService) {
		this.dateRepository = dateRepository;
		this.matingService = matingService;
		this.pokeDexRepository = pokeDexRepository;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("")
	public ResponseEntity<List<DateDomain>> all() {
		return ok(dateRepository.findAll());
	}

	// curl -X GET 'http://localhost:8080/v1/dates?successful=true&finished=true'
	@GetMapping("/detail")
	public ResponseEntity<List<DateDomain>> get(@RequestParam boolean finished, @RequestParam boolean successful) {
		return ok(this.dateRepository.findBySucessAndFinishedQuery(successful, finished));
	}

	// curl -X POST localhost:8080/v1/dates -d '{ "pokeDexId1": "1",
	// "pokeDexId2":"3"}' -H "Content-Type: application/json"
	@PostMapping("")
	@CrossOrigin
	public ResponseEntity<DateDomain> post(@RequestBody DateRequestDto request) {
		List<PokeDexDomain> poke1 = this.pokeDexRepository.findByPokeDexId(request.getPokeDexId1());
		List<PokeDexDomain> poke2 = this.pokeDexRepository.findByPokeDexId(request.getPokeDexId2());

		if (poke1.isEmpty() || poke2.isEmpty()) {
			return badRequest().build();
		}
		PokeDexDomain pokemon1 = poke1.get(0);
		PokeDexDomain pokemon2 = poke2.get(0);

		PokeDexDomain baby = matingService.mate(pokemon1, pokemon2);
		boolean successful = baby != null;

		DateDomain currentDate = new DateDomain();
		currentDate.setPokemon1(pokemon1);
		currentDate.setPokemon2(pokemon2);
		currentDate.setFinished(true);
		currentDate.setSuccessful(successful);
		if (successful) {
			currentDate.setPokeBaby(baby);
		}
		DateDomain saved = this.dateRepository.save(currentDate);
		return ok(saved);
	}

	@PostMapping("/summary")
	@CrossOrigin
	public ResponseEntity<String> summary(@RequestBody DateRequestDto request) {
		List<PokeDexDomain> poke1 = this.pokeDexRepository.findByPokeDexId(request.getPokeDexId1());
		List<PokeDexDomain> poke2 = this.pokeDexRepository.findByPokeDexId(request.getPokeDexId2());

		if (poke1.isEmpty() || poke2.isEmpty()) {
			return badRequest().build();
		}
		PokeDexDomain pokemon1 = poke1.get(0);
		PokeDexDomain pokemon2 = poke2.get(0);
		return ok(
				String.format("The mating probability is %s", matingService.getMatingProbability(pokemon1, pokemon2)));
	}
}
