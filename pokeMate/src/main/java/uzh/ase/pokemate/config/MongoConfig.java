package uzh.ase.pokemate.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "uzh.ase.pokemate")
public class MongoConfig {
	@Bean
	public MongoClient mongo() {
		/*
		 * char[] password = {'r','o','o','t'}; MongoCredential credential =
		 * MongoCredential.createCredential("root", "pokemate", password);
		 * 
		 * MongoClientSettings settings = MongoClientSettings.builder()
		 * //.credential(credential) .applyToSslSettings(builder ->
		 * builder.enabled(true)) .applyToClusterSettings(builder ->
		 * builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
		 * .build();
		 */
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		return mongoClient;// new MongoClient("localhost", new MongoClientOptions(""));
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "pokemate");
	}
}
