package uzh.ase.pokemate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "uzh.ase.pokemate")
@Profile("docker")
public class MongoConfigDocker {

	@Value("${spring.data.mongodb.docker.uri}")
	private String mongoUri;

	@Bean
	public MongoClient mongo() {
		return MongoClients.create("mongodb://" + mongoUri);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongo(), "pokemate");
	}
}
