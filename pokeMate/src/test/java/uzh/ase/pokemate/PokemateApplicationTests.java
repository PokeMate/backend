package uzh.ase.pokemate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "application-test.properties")
@ActiveProfiles({ "test" })
//@EnableAutoConfiguration(exclude = { MongoConfig.class })
class PokemateApplicationTests {

	@Test
	void contextLoads() {
	}

}
