package uzh.ase.pokemate.service.imageGen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uzh.ase.pokemate.dto.imageGen.ImageGenerationRequestDto;

@Service
@Qualifier("imageService")
public class ImageService implements IImageService {

	@Value("${pokemate.imagegen.baseuri}")
	private String baseUrl;
	
	private static final String GET_IMAGE_REQUEST = "";
	private static final String GEN_IMAGE_REQUEST = "image-generator";

	@Override
	public byte[] createImage(Long pokeDexId1, Long pokeDexId2) {
		ImageGenerationRequestDto requestDto = new ImageGenerationRequestDto(pokeDexId1, pokeDexId2);
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("%s/%s", baseUrl, GEN_IMAGE_REQUEST);
		ResponseEntity<byte[]>   response = restTemplate.postForEntity(url, requestDto, byte[].class);
		return response.getBody();
	}

	@Override
	public byte[] getImage(Long pokeDexId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("%s/%s/%s", baseUrl, GET_IMAGE_REQUEST, pokeDexId);
		ResponseEntity<byte[]> response= restTemplate.getForEntity(url, byte[].class);
		return response.getBody();
	}

}
