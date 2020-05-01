package uzh.ase.pokemate.service.imageGen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uzh.ase.pokemate.dto.imageGen.ImageGenerationRequestDto;

@Service
@Qualifier("imageService")
public class ImageService implements IImageService {

	@Value("${pokemate.imagegen.baseuri}")
	private String baseUrl;
	
	private static final String GET_IMAGE_REQUEST = "image";
	private static final String GEN_IMAGE_REQUEST = "image-generator";

	@Override
	public byte[] createImage(Long pokeDexId1, Long pokeDexId2) {
		String url = String.format("%s/%s", baseUrl, GEN_IMAGE_REQUEST);
		return new RestTemplate().postForEntity(url, new ImageGenerationRequestDto(pokeDexId1, pokeDexId2), byte[].class).getBody();
	}

	@Override
	public byte[] getImage(Long pokeDexId) {
		String url = String.format("%s/%s/%s", baseUrl, GET_IMAGE_REQUEST, pokeDexId);
		return new RestTemplate().getForEntity(url, byte[].class).getBody();
	}

}
