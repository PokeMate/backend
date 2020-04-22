package uzh.ase.pokemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PokemateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemateApplication.class, args);
	}
}
