package uzh.ase.pokemate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uzh.ase.pokemate.service.imageGen.IImageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/image")
public class ImageController {
	@Autowired
	@Qualifier("imageService")
	private IImageService imageService;

	@GetMapping("/{id}")
	public ResponseEntity<byte[]> get(@PathVariable("id") Long id) {
		byte[] pokeImage = this.imageService.getImage(id);
		return new ResponseEntity<>(pokeImage, getHeaders(), HttpStatus.OK);
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		headers.setContentType(MediaType.IMAGE_PNG);
		return headers;
	}
}
