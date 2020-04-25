package uzh.ase.pokemate.service.mating;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import uzh.ase.pokemate.domain.FetishDomain;
import uzh.ase.pokemate.repository.FetishRepository;
import uzh.ase.pokemate.service.IFetischService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FetishServiceTest {

	@Autowired
	private FetishRepository fetischRepo;

	@Autowired
	@Qualifier("fetischService")
	IFetischService testee;

	@Before
	public void setup() {
		fetischRepo.deleteAll();
	}

	@Test
	public void testGetFetisches_whenFetishExists_ExpectToGetFetishList() {
		FetishDomain fetish = new FetishDomain();
		fetish.setFetish("Test");
		fetish.setFetishId(0L);
		fetischRepo.insert(fetish);
		List<FetishDomain> fetisches = testee.getFetisches(1);
		assertThat(fetisches.size()).isEqualTo(1);
		assertThat(fetisches.get(0).getFetishId()).isEqualTo(0L);
	}

	@Test
	public void testGetFetisches_whenFetishDoesNotExists_ExpectToGetEmptyFetishList() {
		List<FetishDomain> fetisches = testee.getFetisches(1);
		assertThat(fetisches.size()).isEqualTo(0);
	}

}
