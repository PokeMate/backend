package uzh.ase.pokemate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.service.naming.INameGeneratorService;

@RestController
public class PokeTestRestController {

	@Autowired
	@Qualifier("nameService")
	private INameGeneratorService nameGenService;

	@RequestMapping("/")
	public String index() {
		return String.format("Greetings from PokeMate! Pokemon of the day: %s", nameGenService.generateName());
	}

}