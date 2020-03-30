package uzh.ase.pokemate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokeTestRestController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from PokeMate!";
	}

}