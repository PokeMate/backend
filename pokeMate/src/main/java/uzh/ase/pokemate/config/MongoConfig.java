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
@Profile({ "dev", "test", "default" })
public class MongoConfig {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri; // = "localhost:5003"

	@Bean
	public MongoClient mongo() {
		MongoClient mongoClient = MongoClients.create("mongodb://" + mongoUri);
		return mongoClient;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "pokemate");
	}
}
