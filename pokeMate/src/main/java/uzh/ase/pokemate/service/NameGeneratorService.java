package uzh.ase.pokemate.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Qualifier("nameService")
public class NameGeneratorService implements INameGeneratorService {

	@Value("${pokemate.namegen.basseuri}")
	private String baseUrl;
	private static final String nameRequest = "names?amount=1";

	@Override
	public String generateName() {
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("%s/%s", baseUrl, nameRequest);
		String response = restTemplate.getForObject(url, String.class);
		List<String> readValue = new ArrayList<String>();
		try {
			readValue = Arrays.asList(new ObjectMapper().readValue(response, String[].class));
		} catch (JsonProcessingException e) {
			// ignore exception => use dummy name
			e.printStackTrace();
		}
		String name = "NoName";
		if (!readValue.isEmpty()) {
			name = readValue.get(0);
		}
		return name;
	}
}
